package com.example.backend.security.jwt;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipal;

public interface JwtProvider {

    String generateToken(UserPrincipal auth);

    Authentication getAuthenication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);

}
