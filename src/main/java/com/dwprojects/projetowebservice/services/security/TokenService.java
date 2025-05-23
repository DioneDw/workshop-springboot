package com.dwprojects.projetowebservice.services.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dwprojects.projetowebservice.entities.security.UserAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserAuth userAuth){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("projetowebservice")
                    .withSubject(userAuth.getLogin())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException ex){
            throw new RuntimeException("error while generating token", ex);
        }
    }


    private Instant getExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }



    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("projetowebservice")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException ex){
            return "";
        }

    }
}
