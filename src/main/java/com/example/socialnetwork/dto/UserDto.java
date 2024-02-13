package com.example.socialnetwork.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDto {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
