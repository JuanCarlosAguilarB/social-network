package com.example.socialnetwork.controllers.task;

import com.example.socialnetwork.repositories.TaskRepository;
import com.example.socialnetwork.services.task.ListTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListTaskController {

    @Autowired
    ListTaskServices listTaskServices;
    @GetMapping("/task/")
    public ResponseEntity getTask(Pageable pageable) {
            return ResponseEntity.ok(listTaskServices.listTasks(pageable));
    }
}
