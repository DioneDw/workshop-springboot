package com.dwprojects.projetowebservice.config;

import com.dwprojects.projetowebservice.entities.User;
import com.dwprojects.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","maria@gmail.com","988888888","123456");
        User u2 = new User(null,"Alex Green", "alex@gmail.com","978888887","123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
