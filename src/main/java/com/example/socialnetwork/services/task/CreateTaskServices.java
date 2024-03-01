package com.example.socialnetwork.services.task;

import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskServices {

    @Autowired
    TaskRepository taskRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

}
