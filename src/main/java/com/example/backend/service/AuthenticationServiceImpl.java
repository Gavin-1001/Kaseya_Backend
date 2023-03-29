package com.example.backend.service;

import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{



    @Autowired
    private AM // inject AuthenicationManager from spring security



    @Override
    public User signInAndReturnJwt(User user) {
        return null;
    }
}
