package com.api.exception;

/**
 *
 * @author Miguel Castro
 */
public class UsernameNotFoundException extends RuntimeException {
    
    public UsernameNotFoundException(String mensagem) {
        super(mensagem);
    }
}
