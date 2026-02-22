package com.sfc.eventregistration.security;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
                .subject(username)  //  new method
                .issuedAt(new Date())  //  new method
                .expiration(new Date(System.currentTimeMillis() + expiration))  //  new method
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  //  new parser style
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    private boolean isTokenExpired(String token){
        Date expirationDate=Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

         return expirationDate.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
       final String username=extractUsername(token);
       return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}