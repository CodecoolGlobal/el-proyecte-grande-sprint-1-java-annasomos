package com.codecool.app.backend.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.codecool.app.backend.model.User;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class UserStorage implements UserService {

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

    private User getUserById(UUID id){
        for(User user: users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }

    public void updateUser(UUID id, User updatedUser) {
        User user = getUserById(id);
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(UUID id) {
        User user = getUserById(id);
        users.remove(user);
    }

    public Set<User> getUsers() {
        return users;
    }


}
