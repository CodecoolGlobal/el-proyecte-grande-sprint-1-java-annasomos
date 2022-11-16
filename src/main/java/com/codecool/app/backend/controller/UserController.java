package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.User;
import com.codecool.app.backend.service.UserAlreadyExistsException;
import com.codecool.app.backend.service.UserService;
import com.codecool.app.backend.service.UserServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
public class UserController {

    //private final UserService userService;

    private final UserServiceJpa userServiceJpa;

    @Autowired
    public UserController(UserServiceJpa userServiceJpa) {
        //this.userService = userService;
        this.userServiceJpa = userServiceJpa;
    }

    @GetMapping("users")
    public Set<User> getUsers() {
        System.out.println(userServiceJpa.getUsers());
        return userServiceJpa.getUsers();
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> userAlreadyExists(UserAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PostMapping(value = "users/new")
    public void addUser(@RequestBody User user) {
        userServiceJpa.addUser(user);
    }

     /*@PutMapping(value = "updateuser/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    } */

}
