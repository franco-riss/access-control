package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.mapper.ILogMapper;
import com.s2r.accesscontrol.model.dto.LogRequestDto;
import com.s2r.accesscontrol.model.dto.LogResponseDto;
import com.s2r.accesscontrol.model.entity.LogModel;
import com.s2r.accesscontrol.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService{
    @Autowired
    private ILogRepository repository;

    // CREATE
    public LogResponseDto createLog(LogRequestDto logRequestDto, long userId){
        LogModel log = ILogMapper.INSTANCE.requestDtoToModel(logRequestDto);
        log.setUserId(userId);
        return ILogMapper.INSTANCE.modelToResponseDto(repository.save(log));
    }

    // READ
    public LogResponseDto readLogById(long id){
        LogModel log = repository.findById(id).orElse(null);
        return ILogMapper.INSTANCE.modelToResponseDto(log);
    }
    public List<LogResponseDto> readLogs(){
        List<LogModel> logs = repository.findAll();
        return ILogMapper.INSTANCE.modelListToResponseDtoList(logs);
    }

    // UPDATE
    public LogResponseDto updateLogById(LogRequestDto logRequestDto, long id) {
        LogModel log = ILogMapper.INSTANCE.requestDtoToModel(logRequestDto);
        LogModel existingLogModel = repository.findById(id).orElse(null);

        existingLogModel.setTag(log.getTag());
        existingLogModel.setEvent(log.getEvent());
        existingLogModel.setCheckDateTime(log.getCheckDateTime());

        return ILogMapper.INSTANCE.modelToResponseDto(repository.save(existingLogModel));
    }

    // DELETE
    public void deleteLogById(long id){
        LogModel log = repository.findById(id).orElse(null);
        repository.delete(log);
    }
}