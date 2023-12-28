package com.s2r.accesscontrol.model.dto;

import com.s2r.accesscontrol.model.EventType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogResponseDto {
    @Schema(description = "Log's ID", example = "10")
    private long id;
    @Schema(description = "Log's date and time", example = "2023-12-12T01:06:25.776Z")
    private LocalDateTime checkDateTime;
    @Schema(description = "Event type", example = "CHECKIN")
    private EventType event;
    @Schema(description = "ID of the user who owns the tag", example = "1")
    private Long userId;
}