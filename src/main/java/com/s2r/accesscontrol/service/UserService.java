package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.mapper.IUserMapper;
import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.model.entity.UserModel;
import com.s2r.accesscontrol.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;

    // CREATE
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        UserModel user = IUserMapper.INSTANCE.requestDtoToModel(userRequestDto);
        return IUserMapper.INSTANCE.modelToResponseDto(repository.save(user));
    }

    // READ
    public UserResponseDto readUserById(long id){
        UserModel user = repository.findById(id).orElse(null);
        return IUserMapper.INSTANCE.modelToResponseDto(user);
    }
}