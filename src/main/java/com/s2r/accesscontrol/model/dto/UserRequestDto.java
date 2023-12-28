package com.s2r.accesscontrol.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    @Schema(description = "User's lastname", example = "Wilson")
    private String lastName;
    @Schema(description = "User's firstname", example = "John")
    private String firstName;
    @Schema(description = "Four digits password", example = "0123")
    private String password;
    @Schema(description = "User's sector", example = "Sales")
    private String sector;
    @Schema(description = "User's phone", example = "+541112345678")
    private String phone;
    @Schema(description = "User's email", example = "johnwilson@gmail.com")
    private String email;
    @Schema(description = "Tags list", example = "[\"3A1V\"]")
    private List<String> tags;
}