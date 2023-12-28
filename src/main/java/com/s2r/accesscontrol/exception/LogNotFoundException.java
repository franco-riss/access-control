package com.s2r.accesscontrol.exception;

public class LogNotFoundException extends RuntimeException{
    public LogNotFoundException(){
        super("No log found with the specified ID");
    }
}