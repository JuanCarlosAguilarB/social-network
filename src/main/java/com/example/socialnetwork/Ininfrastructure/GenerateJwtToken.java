package com.example.socialnetwork.Ininfrastructure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDate;


public class GenerateJwtToken{

    public GenerateJwtToken(String username) {
        this.username = username;
        this.accessToken = generateToken(accessTokenExpirationInDays);
        this.refreshToken = generateToken(refreshTokenExpirationInDays);
    }

//     get secret from environment variable
//    @Value("${jwt.secret}")
    private String secret = "secret";

    @Value("${jwt.accessTokenExpirationInDays:10}")
    private int accessTokenExpirationInDays = 1000;

    @Value("${jwt.refreshTokenExpirationInDays:11}")
    private int refreshTokenExpirationInDays = 1100;
    private LocalDate now = LocalDate.now();

    private String accessToken;
    private String refreshToken;

    private String username;

    final Algorithm algorithm = Algorithm.HMAC256(this.secret);
    public String generateToken(int expirationInDays) {

        LocalDate expiryDate = now.plusDays(expirationInDays);
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(java.sql.Timestamp.valueOf(now.atStartOfDay()))
                .withExpiresAt(java.sql.Timestamp.valueOf(expiryDate.atStartOfDay()))
                .sign(algorithm);
    }



    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
