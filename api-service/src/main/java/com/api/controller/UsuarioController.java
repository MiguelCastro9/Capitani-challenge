package com.api.controller;

import com.api.dto.UsuarioRequestDto;
import com.api.dto.UsuarioResponseDto;
import com.api.model.UsuarioModel;
import com.api.service.UsuarioService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/{username}")
    public ResponseEntity<UsuarioResponseDto> salvar(@PathVariable String username, @RequestBody UsuarioRequestDto usuarioRequestDto) {

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
