package com.s2r.accesscontrol.service;

import com.s2r.accesscontrol.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;
}
