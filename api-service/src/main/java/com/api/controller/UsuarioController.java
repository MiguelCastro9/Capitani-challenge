package com.api.controller;

import com.api.dto.UsuarioRequestDto;
import com.api.dto.UsuarioResponseDto;
import com.api.model.UsuarioModel;
import com.api.service.UsuarioService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioRequestDto apiGithub(String username, UsuarioRequestDto usuarioRequestDto) {

        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.github.com")
                .path("users")
                .queryParam(username)
                .build();
        
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<UsuarioRequestDto> entity = restTemplate.getForEntity(uri.toUriString(), UsuarioRequestDto.class);
        


        return usuarioRequestDto;
    }

    @PostMapping("/{username}")
    public ResponseEntity<UsuarioResponseDto> salvar(@PathVariable String username, UsuarioRequestDto usuarioRequestDto) {

        apiGithub(username, usuarioRequestDto);
        System.out.println(usuarioRequestDto.toString());
        UsuarioModel usuario = usuarioService.salvar(usuarioRequestDto.converterUsuarioDtoParaEntidade());
        return new ResponseEntity<UsuarioResponseDto>(UsuarioResponseDto.converterEntidadeParaUsuarioDto(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {

        return new ResponseEntity<List<UsuarioResponseDto>>(
                usuarioService.listar().stream().map(usuario
                        -> UsuarioResponseDto.converterEntidadeParaUsuarioDto(usuario))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}
