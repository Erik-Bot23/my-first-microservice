package com.erikjarquin.microservice_users.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("User not found with id:"+id);
    }
}
