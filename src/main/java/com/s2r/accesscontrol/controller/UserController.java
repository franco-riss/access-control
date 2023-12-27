package com.s2r.accesscontrol.controller;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

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
    @GetMapping(path="/")
    public ResponseEntity<?> getUsers(){
        List<UserResponseDto> users = userService.readUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // PUT
    @PutMapping(path="/{id}")
    public ResponseEntity<?> putUserById(@RequestBody UserRequestDto userRequestDto, @PathVariable long id){
        UserResponseDto user = userService.updateUserById(userRequestDto, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}