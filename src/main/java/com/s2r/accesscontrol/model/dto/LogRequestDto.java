package com.s2r.accesscontrol.model.dto;

import com.s2r.accesscontrol.model.EventType;
import lombok.Data;

@Data
public class LogRequestDto {
    private String tag;
    private EventType event;
}