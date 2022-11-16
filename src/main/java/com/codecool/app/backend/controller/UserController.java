package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.User;
import com.codecool.app.backend.exception.UserAlreadyExistsException;
import com.codecool.app.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public Set<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "user/new")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }


    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> userAlreadyExists(UserAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
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
