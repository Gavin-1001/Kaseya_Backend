package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    // inject AuthenicationManager from spring security
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;

    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public User signInAndReturnJwt(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setAccessToken(jwt);
        signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getId()).getTokenId());


        return signInUser;
    }
}
