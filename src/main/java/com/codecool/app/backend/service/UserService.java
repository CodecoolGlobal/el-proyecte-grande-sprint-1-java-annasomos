package com.codecool.app.backend.service;

import java.util.Set;
import java.util.UUID;

import com.codecool.app.backend.model.User;

public interface UserService {

    void deleteUser(UUID id);

    void updateUser(UUID id, User user);

    void addUser(User user);

    Set<User> getUsers();

}
