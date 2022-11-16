package com.codecool.app.backend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.codecool.app.backend.dao.UserDao;
import com.codecool.app.backend.exception.UserAlreadyExistsException;
import com.codecool.app.backend.model.User;
import com.codecool.app.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDao {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
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
        var oldUser = userRepository.findByUserName(user.getUserName());
        if (oldUser.isPresent()) {
            throw new UserAlreadyExistsException(user.getUserName());
        }
        userRepository.save(user);
    }

    @Override
    public Set<User> getUsers() {
        List<User> allUsers=userRepository.findAll();
        return new HashSet<>(allUsers);
    }

}
