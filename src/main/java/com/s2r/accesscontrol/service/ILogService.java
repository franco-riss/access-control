package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.model.dto.LogRequestDto;
import com.s2r.accesscontrol.model.dto.LogResponseDto;

import java.util.List;

public interface ILogService {

    // CREATE
    LogResponseDto createLog(LogRequestDto logRequestDto, long userId);

    // READ
    LogResponseDto readLogById(long id);
    List<LogResponseDto> readLogs();

    // UPDATE
    LogResponseDto updateLogById(LogRequestDto logRequestDto, long id);

    // DELETE
    void deleteLogById(long id);
}