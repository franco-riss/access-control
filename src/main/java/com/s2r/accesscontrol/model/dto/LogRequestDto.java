package com.s2r.accesscontrol.model.dto;

import com.s2r.accesscontrol.model.EventType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LogRequestDto {
    @Schema(description = "Four characters tag", example = "3A1V")
    private String tag;
    @Schema(description = "Event type", example = "CHECKIN")
    private EventType event;
}