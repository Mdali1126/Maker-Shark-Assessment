package com.makershark.Assessment.exception;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        System.out.println("User Not Found " + username);
    }

}
