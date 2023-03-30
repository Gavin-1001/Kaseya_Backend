package com.example.backend.security.jwt;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipal;

public class JwtProviderImpl implements JwtProvider{
    @Override
    public String generateToken(UserPrincipal auth) {
        return null;
    }

    @Override
    public Authentication getAuthenication(HttpServletRequest request) {
        return null;
    }

    @Override
    public boolean isTokenValid(HttpServletRequest request) {
        return false;
    }
}
