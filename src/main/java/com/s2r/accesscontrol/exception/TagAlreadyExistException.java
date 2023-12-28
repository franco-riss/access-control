package com.s2r.accesscontrol.exception;

public class TagAlreadyExistException extends RuntimeException{
     public TagAlreadyExistException(){
            super("User's tag already exist");
        }
}