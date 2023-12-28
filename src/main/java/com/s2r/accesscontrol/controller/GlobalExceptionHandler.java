package com.s2r.accesscontrol.controller;

import com.s2r.accesscontrol.exception.EmptyListException;
import com.s2r.accesscontrol.exception.LogNotFoundException;
import com.s2r.accesscontrol.exception.TagAlreadyExistException;
import com.s2r.accesscontrol.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LogNotFoundException.class)
    public ResponseEntity<?> LogNotFoundExceptionHandler(LogNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<?> EmptyListExceptionHandler(EmptyListException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TagAlreadyExistException.class)
    public ResponseEntity<?> TagAlreadyExistExceptionHandler(TagAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}