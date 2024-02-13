package com.example.socialnetwork.Ininfrastructure;

import org.springframework.security.core.userdetails.UserDetails;

public interface IValidateToken {

    public Boolean isValidToken(String token, UserDetails userDetails);
}
