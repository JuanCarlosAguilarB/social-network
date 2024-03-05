package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.InvalidRequestArgumentException;
import com.example.socialnetwork.repositories.UserRepository;
import com.example.socialnetwork.services.CreateUserServices;
import com.example.socialnetwork.utils.EmailValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "User management operations")
@RestController
public class CreateUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CreateUserServices createUserServices;

    @Operation(summary = "Create a new user", description = "Creates a new user", tags = { "User" })
    @PostMapping(value = "/users/")
    public ResponseEntity createUser(@RequestBody RequestUserBody requestBody) {
        User user = User.Builder.anUser()
                .withUsername(requestBody.getUsername())
                .withEmail(requestBody.getEmail())
                .withFirstName(requestBody.getFirstName())
                .withLastName(requestBody.getLastName())
                .withPhoneNumber(requestBody.getPhoneNumber())
                .withPassword(passwordEncoder.encode( requestBody.getPassword()))
                .build();

        return ResponseEntity.ok().header("Authorization", "Bearer " + createUserServices.createUser(user).getToken()).build();

    }


    @Autowired
    UserRepository userRepository;

    @Operation(summary = "Get a user", description = "Get a user by its id..... not implement", tags = { "User" })
    @GetMapping(value = "/users/me/")
    public User getUser() {

        User user = userRepository.findByUsername("1");
        return user;
    }
}


@Getter
class RequestUserBody{
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public void setEmail(String email) {

        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.isValidEmail(email) || email == null) {
            throw new InvalidRequestArgumentException("Invalid email");
        }
        this.email = email;
    }
}
