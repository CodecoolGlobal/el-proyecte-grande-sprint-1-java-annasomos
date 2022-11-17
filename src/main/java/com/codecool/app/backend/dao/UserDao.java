package com.codecool.app.backend.dao;

import java.util.Set;
import java.util.UUID;

import com.codecool.app.backend.model.User;
import org.springframework.stereotype.Service;

public interface UserDao {

    void deleteUser(UUID id);

    void updateUser(UUID id, User user);

    void addUser(User user);

    Set<User> getUsers();

}