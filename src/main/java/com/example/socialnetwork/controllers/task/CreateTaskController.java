package com.example.socialnetwork.controllers.task;

import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.entities.User;
import com.example.socialnetwork.repositories.TaskRepository;
import com.example.socialnetwork.repositories.UserRepository;
import com.example.socialnetwork.services.task.CreateTaskServices;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTaskController {

    @Autowired
    CreateTaskServices createTaskServices;

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/task/")
    public ResponseEntity createTask(@RequestBody CreateTaskRequest createTaskRequest, Authentication authentication) {


        Task task = Task.builder()
                .name(createTaskRequest.getName())
                .description(createTaskRequest.getDescription())
                .statusId(createTaskRequest.getStatusId())
                .boardId(createTaskRequest.getBoardId())
                .build();
        createTaskServices.createTask(task);

        return ResponseEntity.ok().build();
    }

}




@Getter
@Setter
//@Builder
class CreateTaskRequest {
    private String name;
    private String description;
    private int boardId;
    private int statusId;
}