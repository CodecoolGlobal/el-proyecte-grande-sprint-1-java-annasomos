package com.codecool.app.backend.exception;

public class PubAlreadyExistsException extends RuntimeException {
    public PubAlreadyExistsException(String name) {
        super(String.format("Pub already exists: %s", name));
    }

    public PubAlreadyExistsException(String name, Throwable cause) {
        super(String.format("Pub already exists: %s", name), cause);
    }
}
