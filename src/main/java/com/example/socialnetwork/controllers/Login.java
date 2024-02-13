package com.example.socialnetwork.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
