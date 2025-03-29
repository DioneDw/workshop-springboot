package com.dwprojects.projetowebservice.repositories.security;

import com.dwprojects.projetowebservice.entities.security.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserAuthRepository extends JpaRepository<UserAuth, String> {

    UserDetails findByLogin(String login);
}
