package com.dwprojects.projetowebservice.repositories;

import com.dwprojects.projetowebservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
