package com.example.backend.service;

import com.example.backend.LoginResponse;
import com.example.backend.dto.LoginDto;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService{


    User saveUser(User user);

    Optional<User> findByUsername(String username);
}
