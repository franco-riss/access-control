package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;

import java.util.List;

public interface IUserService {

    // CREATE
    UserResponseDto createUser(UserRequestDto userRequestDto);

    // READ
    UserResponseDto readUserById(long id);
    List<UserResponseDto> readUsers();

    // UPDATE
    UserResponseDto updateUserById(UserRequestDto userRequestDto, long id);

    // DELETE
    void deleteUserById(long id);
}