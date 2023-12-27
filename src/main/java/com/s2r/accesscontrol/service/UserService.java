package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.mapper.IUserMapper;
import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.model.entity.UserModel;
import com.s2r.accesscontrol.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserResponseDto> readUsers(){
        List<UserModel> users = repository.findAll();
        return IUserMapper.INSTANCE.modelListToResponseDtoList(users);
    }

    // UPDATE
    public UserResponseDto updateUserById(UserRequestDto userRequestDto, long id) {
        UserModel userModel = IUserMapper.INSTANCE.requestDtoToModel(userRequestDto);
        UserModel existingUserModel = repository.findById(id).orElse(null);
        userModel.setUserId(id);
        userModel.setLogModels(existingUserModel.getLogModels());
        return IUserMapper.INSTANCE.modelToResponseDto(repository.save(userModel));
    }

    // DELETE
    public void deleteUserById(long id){
        UserModel user = repository.findById(id).orElse(null);
        repository.delete(user);
    }

    // Used to identify tag's owner
    public long readUserIdByTag(String tag) {
        UserModel user = repository.findByTagsContains(tag).orElse(null);
        return user.getUserId();
    }
}