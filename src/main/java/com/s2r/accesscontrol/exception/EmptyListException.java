package com.s2r.accesscontrol.exception;

public class EmptyListException extends RuntimeException{
    public EmptyListException(){
        super("List is empty");
    }
}