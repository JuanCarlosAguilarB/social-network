package com.example.socialnetwork.controllers.board;


import com.example.socialnetwork.entities.Topic;
import com.example.socialnetwork.services.board.CreateTopicService;
import com.example.socialnetwork.services.user.GetUserByUsername;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.websocket.server.PathParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Board", description = "Board management operations")
@RestController
public class CreateTopicController {

    @Autowired
    private CreateTopicService createTopicService;

    @Autowired
    private GetUserByUsername getUserByUsername;

    @Operation(summary = "Create a new topic", description = "Creates a new topic for the authenticated user", tags = { "Board" })
    @PostMapping("/board/{boardId}/topic/")
    public void createTopic(@RequestBody CreateTopicRequest createTopicRequest, Authentication auth, @PathVariable UUID boardId) {

        String username = auth.getName();
        UUID userId = getUserByUsername.getUserByUsername(username).getId();

        Topic topic = Topic.builder()
                .name(createTopicRequest.getName())
                .description(createTopicRequest.getDescription())
                .colorId(createTopicRequest.getColor())
                .userId(userId)
                .boardId(boardId)
                .build();

        createTopicService.createTopic(topic);
    }
}

@Setter
@Getter
class CreateTopicRequest {
    private String name;
    private String description;
    private int color;

}
