package com.example.socialnetwork.services.task;

import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTaskServices {

    @Autowired
    TaskRepository taskRepository;


    public Page<Task> listTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
    public List<Task> listTasksSliced(Pageable pageable) {
        return (List<Task>) taskRepository.findAll(pageable);
    }
}
