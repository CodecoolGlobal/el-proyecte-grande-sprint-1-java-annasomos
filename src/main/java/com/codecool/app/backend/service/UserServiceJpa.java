package com.codecool.app.backend.service;

import java.util.Set;
import java.util.UUID;

import com.codecool.app.backend.model.User;
import com.codecool.app.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceJpa implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(UUID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUser(UUID id, User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addUser(User user) {
        var oldUser = userRepository.findByName(user.getUserName());
        if (oldUser.isPresent()) {
            throw new UserAlreadyExistsException(user.getUserName());
        }
        userRepository.save(user);
    }

    @Override
    public Set<User> getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

}
