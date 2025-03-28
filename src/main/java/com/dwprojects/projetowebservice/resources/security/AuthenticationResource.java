package com.dwprojects.projetowebservice.resources.security;

import com.dwprojects.projetowebservice.entities.security.AuthenticationDTO;
import com.dwprojects.projetowebservice.entities.security.LoginResponseDTO;
import com.dwprojects.projetowebservice.entities.security.RegisterDTO;
import com.dwprojects.projetowebservice.entities.security.UserAuth;
import com.dwprojects.projetowebservice.repositories.security.UserAuthRepository;
import com.dwprojects.projetowebservice.services.security.TokenService;
import jakarta.validation.Valid;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAuthRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) throws AuthenticationException {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(),authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generatedToken((UserAuth) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){

        if(this.repository.findByLogin(registerDTO.login()) != null ){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        UserAuth newUser = new UserAuth(registerDTO.login(), encryptedPassword , registerDTO.role());

        this.repository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
