package com.caribedev.TaskManager.Infrastructure.Security;

import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

   private final String SECRET = "d8f3e0c5ab43f195aa21db41e50ad83e8f4029fc84f13f6ab7c6b88de1024af5";
    private final Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());
   private final long expirationMillis = Duration.ofHours(1).toMillis();

   public String generateToken(String userId, String username, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuer("caribedev.com")
                .claim("aud", List.of("web.caribedev.com","movil.caribedev.com"))
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    public Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Key getSecretKey() {
        return secretKey;
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }
}
