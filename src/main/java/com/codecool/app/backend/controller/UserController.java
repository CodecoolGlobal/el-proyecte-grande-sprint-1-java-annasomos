package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.User;
import com.codecool.app.backend.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
public class UserController {


    public UserStorage userStorage;

    @Autowired
    public UserController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }



    @GetMapping("users")
    public Set<User> getUsers() {
        return userStorage.getUsers();
    }

    @PostMapping(value = "users/new")
    public void addUser(@RequestBody User user) {
        userStorage.addUser(user);
    }

    @PutMapping(value="updateuser/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody User user){
        userStorage.updateUser(id, user);
    }





}
