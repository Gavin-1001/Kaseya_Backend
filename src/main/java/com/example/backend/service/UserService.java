package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.requests.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService{


//    User saveUser(UserDto userRequest);

    User saveUser(User user);
    Optional<User> findByUsername(String username);

    List<User> findAllUsers();
}
