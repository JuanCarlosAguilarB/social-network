package com.example.socialnetwork.Ininfrastructure;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

@Service
public class GetUsernameFromToken implements IGetUsernameFromToken{

    public String getUsernameFromToken(String token)
    {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getSubject();
    }


}
