package com.s2r.accesscontrol.mapper;

import com.s2r.accesscontrol.model.dto.LogRequestDto;
import com.s2r.accesscontrol.model.dto.LogResponseDto;
import com.s2r.accesscontrol.model.entity.LogModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ILogMapper {
    ILogMapper INSTANCE = Mappers.getMapper(ILogMapper.class);

    LogResponseDto modelToResponseDto(LogModel logModel);

    @IterableMapping(elementTargetType = LogResponseDto.class)
    List<LogResponseDto> modelListToResponseDtoList(List<LogModel> logModelList);
    @Mapping(target = "checkDateTime", ignore = true)
    LogModel requestDtoToModel(LogRequestDto logRequestDto);
    @AfterMapping
    default void setCheckDateTime(LogRequestDto logRequestDto, @MappingTarget LogModel logModel) {
        logModel.setCheckDateTime(LocalDateTime.now());
    }
}