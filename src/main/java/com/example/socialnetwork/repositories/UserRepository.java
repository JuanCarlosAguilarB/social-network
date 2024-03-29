package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<User, UUID> {

    public boolean existsByEmail(String email);
    public boolean existsByUsername(String username);
    public User findByUsername(String username);

    public User findByEmail(String email);

}
