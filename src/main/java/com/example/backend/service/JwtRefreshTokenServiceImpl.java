package com.example.backend.service;

import com.example.backend.entity.JwtRefreshToken;
import com.example.backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService {
    @Override
    public JwtRefreshToken createRefreshToken(Long userId) {
        return null;
    }

    @Override
    public User generateAccessTokenFromRefreshToken(String refreshTokenId) {
        return null;
    }
}
