package com.api.repository;

import com.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
}
