package com.s2r.accesscontrol.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    private String lastName;
    private String firstName;
    private String password;
    private String sector;
    private String phone;
    private String email;
    private List<String> tags;
}
