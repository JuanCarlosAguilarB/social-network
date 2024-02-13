package com.example.socialnetwork.controllers;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthJwtResponse {

    private String token;
    private String refreshToken;

}
