package com.dwprojects.projetowebservice.entities.security;

import com.dwprojects.projetowebservice.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
