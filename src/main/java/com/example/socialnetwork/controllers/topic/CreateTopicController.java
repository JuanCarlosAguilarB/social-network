package com.example.socialnetwork.controllers.topic;


import com.example.socialnetwork.entities.Topic;
import com.example.socialnetwork.services.topic.CreateTopicService;
import com.example.socialnetwork.services.user.GetUserByUsername;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Topic", description = "Topic management operations")
@RestController
public class CreateTopicController {

    @Autowired
    CreateTopicService createTopicServices;

    @Autowired
    GetUserByUsername getUserByUsername;


    @Operation(summary = "Create a new topic", description = "Creates a new topic", tags = { "Topic" })
    @PostMapping("/topics/")
    public ResponseEntity createTopic(@RequestBody CreateTopicRequest createTopicRequest, Authentication authentication){

        String username = authentication.getName();
        UUID userId = getUserByUsername.getUserByUsername(username).getId();

        Topic topic = new Topic().builder()
                .name(createTopicRequest.getName())
                .description(createTopicRequest.getDescription())
                .boardId(createTopicRequest.getBoardId())
                .colorId(createTopicRequest.getColorId())
                .userId(userId)
                .build();

        createTopicServices.createTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

@Getter
@Setter
class CreateTopicRequest {
    private String name;
    private String description;
    private Integer colorId;
    private UUID boardId;
}
