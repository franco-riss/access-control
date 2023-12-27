package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;

public interface IUserService {

    // CREATE
    UserResponseDto createUser(UserRequestDto userRequestDto);

    // READ
    UserResponseDto readUserById(long id);
}
