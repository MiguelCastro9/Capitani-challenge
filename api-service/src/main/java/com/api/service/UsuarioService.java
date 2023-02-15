package com.api.service;

import com.api.model.UsuarioModel;
import com.api.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        
        return usuarioRepository.save(usuarioModel);
    }
    
    public List<UsuarioModel> listar() {
        
        return usuarioRepository.findAll();
    }
    
}
