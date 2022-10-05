package com.codecool.app.backend.service;

import com.codecool.app.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserStorage {

    private final Set<User> users;

    public UserStorage() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsersByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toSet());
    }

    private User getUserByEmail(String email) {
        for(User user: users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new RuntimeException();
    }

    public void updateName(String newName, String email) {
        User user = getUserByEmail(email);
        user.setName(newName);
    }

    public void updateEmail(String oldEmail, String newEmail) {
        User user = getUserByEmail(oldEmail);
        user.setEmail(newEmail);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }
}
