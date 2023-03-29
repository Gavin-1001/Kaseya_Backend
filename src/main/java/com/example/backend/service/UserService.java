package com.example.backend.service;

import com.example.backend.LoginResponse;
import com.example.backend.dto.LoginDto;
import com.example.backend.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService{

    String addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);
}
