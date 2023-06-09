package com.example.backend.controller;


import com.example.backend.entity.User;
import com.example.backend.service.authService.AuthenticationService;
import com.example.backend.service.jwtTokenService.JwtRefreshTokenService;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent())  {
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
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
