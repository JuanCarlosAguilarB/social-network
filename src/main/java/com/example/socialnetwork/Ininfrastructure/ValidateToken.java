package com.example.socialnetwork.Ininfrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidateToken implements IValidateToken {

    public Boolean isValidToken(String token, UserDetails userDetails) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);

            LocalDate now = LocalDate.now();

            if(
                    decodedJWT.getExpiresAt().before(java.sql.Date.valueOf(now)) &&
                    !decodedJWT.getSubject().equals(userDetails.getUsername())
            )
            {
                return false;
            }

            return true;

        } catch (JWTDecodeException exception) {
            return false;
        }
    }
}
