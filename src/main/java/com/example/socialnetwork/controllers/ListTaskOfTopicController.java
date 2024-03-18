package com.example.socialnetwork.controllers;

import com.example.socialnetwork.controllers.task.GetTaskOfTopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Tag(name = "Topic" , description = "List all tasks of a topic")
public class ListTaskOfTopicController {

    @Autowired
    private GetTaskOfTopicService getTaskOfTopicService;


    @GetMapping("/topic/{topicId}/tasks")
    public ResponseEntity getTaskOfTopic(@PathVariable UUID topicId, Pageable pageable) {
        return ResponseEntity.ok(getTaskOfTopicService.getTaskOfTopic(topicId, pageable));
    }
}
