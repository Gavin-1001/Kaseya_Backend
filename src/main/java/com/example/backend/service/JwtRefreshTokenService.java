package com.example.backend.service;

import com.example.backend.entity.JwtRefreshToken;
import com.example.backend.entity.User;

public interface JwtRefreshTokenService {

    JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
