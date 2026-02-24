package com.example.online.thrift.store.util;

import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final UserRepository userRepository;
    private final long expirationTime = 1000 * 60 * 60; // 1 hour
    private final String SECRET = "my-super-secret-key-that-is-long-enough-1234567890!@#";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email) {

        Users user = userRepository.findByEmail(email).get();

        Map<String,String> userDetails = new HashMap<>();
        userDetails.put("role",user.getRole().toString());
        userDetails.put("userId",user.getId().toString());
        userDetails.put("name",user.getName());


        return Jwts.builder()
                .claims(userDetails)
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    public Claims extractClaims(String token){
        return  Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token){
        return extractClaims(token).get("role",String.class);
    }



public boolean validateToken(String token) {
    try {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration().after(new Date());

    } catch (Exception e) {

        return false;
    }
}



//
//    private boolean isTokenExpired(String token) {
//        Claims body = Jwts.parser()
//                .verifyWith(key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//
//        return body.getExpiration().before(new Date());
//    }


}
