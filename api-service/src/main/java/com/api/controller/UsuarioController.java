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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{username}")
    public ResponseEntity<?> salvar(@PathVariable String username) {
        System.out.println(username);
        UsuarioRequestDto usuarioRequestDto = usuarioService.apiGithub(username);
        UsuarioModel usuarioModel = usuarioService.salvar(usuarioRequestDto.converterUsuarioDtoParaEntidade());
        return new ResponseEntity<UsuarioResponseDto>(UsuarioResponseDto.converterEntidadeParaUsuarioDto(usuarioModel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        return new ResponseEntity<List<UsuarioResponseDto>>(
                usuarioService.listar().stream().map(usuario
                        -> UsuarioResponseDto.converterEntidadeParaUsuarioDto(usuario))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}
