package com.s2r.accesscontrol.model.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private long userId;
    private String lastName;
    private String firstName;
    private String sector;
    private String phone;
    private String email;
}
