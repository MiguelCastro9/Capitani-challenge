package com.api.service;

import com.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
}
