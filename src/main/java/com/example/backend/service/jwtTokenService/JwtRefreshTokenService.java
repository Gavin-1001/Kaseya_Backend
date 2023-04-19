package com.example.backend.service.jwtTokenService;

import com.example.backend.entity.JwtRefreshToken;
import com.example.backend.entity.User;

import java.util.UUID;

public interface JwtRefreshTokenService {

    JwtRefreshToken createRefreshToken(String userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
