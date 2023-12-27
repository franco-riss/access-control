package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.model.entity.UserModel;
import com.s2r.accesscontrol.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;

    // CREATE
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        // TODO MAPPER requestDtoToModel
        UserModel user = new UserModel();
        return null;
    }

    // READ
    public UserResponseDto readUserById(long id){
        // TODO MAPPER modelToResponseDto
        Optional<UserModel> user = repository.findById(id);
        return null;
    }
}