package com.codecool.app.backend.configuration;

import com.codecool.app.backend.repositories.UserRepository;
import com.codecool.app.backend.service.UserService;
import com.codecool.app.backend.service.UserServiceJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
public class JpaConfiguration {
    private UserRepository userRepository;

    @Autowired
    public JpaConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService getJpaUserService() {
        return new UserServiceJpa(userRepository);
    }
}
