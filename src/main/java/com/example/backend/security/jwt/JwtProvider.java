package com.example.backend.security.jwt;


import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

import com.example.backend.security.UserPrincipal;

public interface JwtProvider {


    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);


}
