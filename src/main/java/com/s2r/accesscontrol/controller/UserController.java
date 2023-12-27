package com.s2r.accesscontrol.controller;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    // POST
    @PostMapping(path="/")
    public ResponseEntity<?> postUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto user = userService.createUser(userRequestDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // GET
    @GetMapping(path="/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id){
        UserResponseDto user = userService.readUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
