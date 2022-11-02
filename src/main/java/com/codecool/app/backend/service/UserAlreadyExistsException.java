package com.codecool.app.backend.service;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String userName) {
        super(String.format("User already exists: %s", userName));
    }

    public UserAlreadyExistsException(String userName, Throwable cause) {
        super(String.format("User already exists: %s", userName), cause);
    }

}
