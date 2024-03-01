package com.example.socialnetwork.controllers;

import com.example.socialnetwork.Ininfrastructure.GenerateJwtToken;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/auth/login/")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // authentication.getName() returns the email of the user


        GenerateJwtToken createToken = new GenerateJwtToken(authentication.getName());

        return ResponseEntity.ok(new AuthJwtResponse(createToken.getAccessToken(), createToken.getRefreshToken()));
    }
}

@Getter
class LoginRequest {
    private String username;
    private String password;

}