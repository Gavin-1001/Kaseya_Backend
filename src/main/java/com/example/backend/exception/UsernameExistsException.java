package com.example.backend.exception;

public class UsernameExistsException extends Exception {
    public UsernameExistsException(String errorMessage){
        super(errorMessage);
    }
}
