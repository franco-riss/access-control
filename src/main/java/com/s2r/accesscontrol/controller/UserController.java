package com.s2r.accesscontrol.controller;

import com.s2r.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
}
