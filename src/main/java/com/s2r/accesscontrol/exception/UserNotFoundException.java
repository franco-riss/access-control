package com.s2r.accesscontrol.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("No user found with the specified ID");
    }
}