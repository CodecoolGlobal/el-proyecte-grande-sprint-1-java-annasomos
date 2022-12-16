package com.codecool.app.backend.service;

import java.util.*;

import com.codecool.app.backend.exception.UserAlreadyExistsException;
import com.codecool.app.backend.model.User;
import com.codecool.app.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(User user) {
        var oldUser = userRepository.findByUserName(user.getUserName());
        if (oldUser.isPresent()) {
            throw new UserAlreadyExistsException(user.getUserName());
        }
        userRepository.save(user);
    }

    public void addFriends(UUID userId, UUID friendsId) {
        userRepository.saveFriends(userId, friendsId);
        userRepository.saveFriends(friendsId, userId);
    }

    public Set<User> getFriendsByUserId(UUID userId) {
        return userRepository.getFriendsByUserId(userId);
    }
    public void getFriendsByFriendsId(UUID friendsId) {
        userRepository.getFriendsByFriendsId(friendsId);
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }


    public Set<User> getUsers() {
        List<User> allUsers=userRepository.findAll();
        return new HashSet<>(allUsers);
    }


}
