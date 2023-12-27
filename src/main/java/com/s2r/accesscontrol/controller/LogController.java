package com.s2r.accesscontrol.controller;

import com.s2r.accesscontrol.model.dto.LogRequestDto;
import com.s2r.accesscontrol.model.dto.LogResponseDto;
import com.s2r.accesscontrol.service.ILogService;
import com.s2r.accesscontrol.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/logs")
public class LogController {
    @Autowired
    private ILogService logService;
    @Autowired
    private IUserService userService;

    // POST
    @PostMapping(path="/")
    public ResponseEntity<?> postLog(@RequestBody LogRequestDto logRequestDto){
        long userId = userService.readUserIdByTag(logRequestDto.getTag());
        LogResponseDto log = logService.createLog(logRequestDto, userId);
        return new ResponseEntity<>(log, HttpStatus.CREATED);
    }

    // GET
    @GetMapping(path="/{id}")
    public ResponseEntity<?> getLogById(@PathVariable long id){
        LogResponseDto log = logService.readLogById(id);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }
    @GetMapping(path="/")
    public ResponseEntity<?> getLogs(){
        List<LogResponseDto> logs = logService.readLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // PUT
    @PutMapping(path="/{id}")
    public ResponseEntity<?> putLogById(@RequestBody LogRequestDto logRequestDto, @PathVariable long id){
        LogResponseDto log = logService.updateLogById(logRequestDto, id);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteLogById(@PathVariable long id){
        logService.deleteLogById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}