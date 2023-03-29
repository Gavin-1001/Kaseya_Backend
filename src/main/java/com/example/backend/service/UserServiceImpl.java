package com.example.backend.service;


import com.example.backend.LoginResponse;
import com.example.backend.dto.LoginDto;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                this.passwordEncoder.encode(userDto.getPassword())
        );
        userRepository.save(user);
        return user.getUsername();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User loginUser = userRepository.findByUsername(loginDto.getUsername());
        if(loginUser != null){
            String password = loginDto.getPassword();
            String encodedPassword = loginUser.getPassword();
            Boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
            if(isPasswordMatch){
                Optional<User> user = userRepository.findOneByUsernameAndPassword(loginDto.getUsername(), encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Login is successful", true);
                }else{
                    return new LoginResponse("Login failed", false);
                }
            }else{
                return new LoginResponse("Password does not match ", false);
            }
        }else{
            return new LoginResponse("Email does not exits", false);
        }

    }


}
