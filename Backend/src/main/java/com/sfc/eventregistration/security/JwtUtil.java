package com.sfc.eventregistration.security;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

   private SecretKey getSigningKey() {
    return Keys.hmacShaKeyFor(secretKey.getBytes());
}

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)  // ✅ new method
                .issuedAt(new Date())  // ✅ new method
                .expiration(new Date(System.currentTimeMillis() + expiration))  // ✅ new method
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  // ✅ new parser style
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username);
    }
}