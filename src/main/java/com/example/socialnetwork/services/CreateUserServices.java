package com.example.socialnetwork.services;

import com.example.socialnetwork.Ininfrastructure.GenerateJwtToken;
import com.example.socialnetwork.controllers.AuthJwtResponse;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.DuplicateEmailException;
import com.example.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServices {

    @Autowired
    UserRepository userRepository;

    public AuthJwtResponse createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("The email " + user.getEmail() + " is alredy resistered. Please use another email.");
        }

        GenerateJwtToken generateJwtToken = new GenerateJwtToken(user.getUsername());

        userRepository.save(user);
        String token = generateJwtToken.getAccessToken();
        return AuthJwtResponse.builder()
                .token(token)
                .build();
    }

}
