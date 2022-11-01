package br.univille.novostalentos.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
@Service
public class UserDetailsServiceImpl 
        implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        var umUsuario = repository.findByNome(username);

        return new User(umUsuario.getNome(), 
                        umUsuario.getSenha(),
                        new ArrayList<>());
    }
    
}
