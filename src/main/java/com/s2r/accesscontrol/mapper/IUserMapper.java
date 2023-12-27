package com.s2r.accesscontrol.mapper;

import com.s2r.accesscontrol.model.dto.UserRequestDto;
import com.s2r.accesscontrol.model.dto.UserResponseDto;
import com.s2r.accesscontrol.model.entity.UserModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserModel requestDtoToModel(UserRequestDto userRequestDto);
    UserResponseDto modelToResponseDto(UserModel userModel);
    @IterableMapping(elementTargetType = UserResponseDto.class)
    List<UserResponseDto> modelListToResponseDtoList(List<UserModel> userModelList);
}