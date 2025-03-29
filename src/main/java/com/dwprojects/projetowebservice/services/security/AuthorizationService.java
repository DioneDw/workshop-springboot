package com.dwprojects.projetowebservice.services.security;

import com.dwprojects.projetowebservice.repositories.security.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserAuthRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findByLogin(username);

        // Se o usuário não for encontrado, lança uma exceção com uma mensagem personalizada
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o login: " + username);
        }

        return user;
    }


}
