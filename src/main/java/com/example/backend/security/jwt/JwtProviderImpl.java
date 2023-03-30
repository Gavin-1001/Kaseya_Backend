package com.example.backend.security.jwt;

import com.example.backend.security.utils.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.UserPrincipal;
import java.security.Key;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component
public class JwtProviderImpl implements JwtProvider{



    @Override
    public String generateToken(UserPrincipal auth) {
        String authorities = auth.geAuthorities().stream()
                .map(GrantedAuthority:: getAuthority)
                .collect(Collectors.joining(","));

        Key key = Keys.hmacSharSkyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(auth.g)

                ;
    }

    @Override
    public Authentication getAuthenication(HttpServletRequest request) {
        Claims claims = extractClaims(request);

        if(claims == null){
            return null;
        }
        String username = claims.getSubject();
        Long userId = claims.get("userId", Long.class);

        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isTokenValid(HttpServletRequest request) {
        return false;
    }
}
