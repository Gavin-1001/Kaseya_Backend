package com.example.backend.controller;


import com.example.backend.entity.Employee;
import com.example.backend.entity.User;
import com.example.backend.exception.UsernameExistsException;
import com.example.backend.requests.EmployeeDto;
import com.example.backend.requests.UserDto;
import com.example.backend.service.authService.AuthenticationService;
import com.example.backend.service.jwtTokenService.JwtRefreshTokenService;
import com.example.backend.service.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http:localhost:3000")
@RequestMapping("/api/authentication")
public class AuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

   @Autowired
   private JwtRefreshTokenService jwtRefreshTokenService;

//    @PostMapping("/register")
//    public ResponseEntity<?> signUp(@RequestBody User user) throws UsernameExistsException {
//        if (userService.findByUsername(user.getUsername()).isPresent())  {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//
//        }
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }


    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody @Valid UserDto userRequest){
        if (userService.findByUsername(userRequest.getUsername()).isPresent())  {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestParam String token){
        return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
    }

}
