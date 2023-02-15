package com.api.service;

import com.api.dto.UsuarioRequestDto;
import com.api.dto.UsuarioResponseDto;
import com.api.model.UsuarioModel;
import com.api.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Miguel Castro
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioRequestDto apiGithub(String username) {
        
        RestTemplate template = new RestTemplate();
        String url = "https://api.github.com/users/" + username;
        UsuarioRequestDto usuarioRequestDto = template.getForObject(url, UsuarioRequestDto.class);
        return usuarioRequestDto;
    }
    
    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        
        return usuarioRepository.save(usuarioModel);
    }
    
    public List<UsuarioModel> listar() {
        
        return usuarioRepository.findAll();
    }
    
}
