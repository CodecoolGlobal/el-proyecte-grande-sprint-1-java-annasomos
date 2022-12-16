package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.User;
import com.codecool.app.backend.exception.UserAlreadyExistsException;
import com.codecool.app.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

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

    @PostMapping("user/add-friend")
    public void addFriend(@RequestParam(name = "id") UUID userId,
                          @RequestParam(name = "friends_id") UUID friendsId){
        userService.addFriends(userId, friendsId);
    }


    @GetMapping("user/get-my-friends-by-user-id")
    public Set<User> getFriendsByUserId(@RequestParam(name = "user_id") UUID userId) {
        return userService.getFriendsByUserId(userId);
    }
    @GetMapping("user/get-my-friends-by-friends-id")
    public void getFriendsByFriendsId(@RequestParam(name = "app_user_friends.friends_id") UUID friendsId) {
        userService.getFriendsByFriendsId(friendsId);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> userAlreadyExists(UserAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }




}
