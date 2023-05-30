package com.example.backend.service;
import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
@Data
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @Override
//    public User saveUser(@RequestBody User userRequest) {
//
//        userRequest.setRole(Role.USER);
//        User user = User.builder()
//
//                .username(userRequest.getUsername())
//                .password(userRequest.getPassword())
//                .accessToken(userRequest.getAccessToken())
//                .refreshToken(userRequest.getRefreshToken())
//                .role(userRequest.getRole())
//                .build();
//        return userRepository.save(user);
//    }



    @Override
    public User saveUser(User userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRequest.setRole(Role.USER);
        return userRepository.save(userRequest);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
