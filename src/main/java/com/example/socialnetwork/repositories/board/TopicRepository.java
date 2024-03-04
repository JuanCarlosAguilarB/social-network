package com.example.socialnetwork.repositories.board;

import com.example.socialnetwork.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
