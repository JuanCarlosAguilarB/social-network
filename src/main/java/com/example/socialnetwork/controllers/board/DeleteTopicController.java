package com.example.socialnetwork.controllers.board;

import com.example.socialnetwork.repositories.board.TopicRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Board", description = "Board management operations")
@RestController
public class DeleteTopicController {

    @Autowired
    TopicRepository topicRepository;

    @DeleteMapping("/boards/topics/{id}/")
    public void deleteTopic(@PathVariable UUID id) {
        topicRepository.deleteById(id);
    }
}
