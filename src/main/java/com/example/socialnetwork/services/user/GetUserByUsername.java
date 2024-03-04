package com.example.socialnetwork.services.user;

import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.exceptions.UserNotFoundException;
import com.example.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByUsername {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
