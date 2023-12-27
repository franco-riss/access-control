package com.s2r.accesscontrol.model.dto;

import com.s2r.accesscontrol.model.EventType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogResponseDto {
    private long id;
    private LocalDateTime checkDateTime;
    private EventType event;
    private Long userId;
}