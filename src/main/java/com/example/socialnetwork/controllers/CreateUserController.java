package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.InvalidRequestArgumentException;
import com.example.socialnetwork.repositories.UserRepository;
import com.example.socialnetwork.services.CreateUserServices;
import com.example.socialnetwork.utils.EmailValidator;
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

@RestController
public class CreateUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CreateUserServices createUserServices;
    @PostMapping(value = "/user/")
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

    @GetMapping(value = "/auth/user")
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
