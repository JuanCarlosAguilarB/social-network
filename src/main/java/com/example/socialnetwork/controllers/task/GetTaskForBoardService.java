package com.example.socialnetwork.controllers.task;

import com.example.socialnetwork.entities.TaskListDTO;
import com.example.socialnetwork.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class GetTaskForBoardService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskListDTO> getTaskForBoard(UUID topicId, Pageable pageable) {

        log.info("Get task for board service");
        return taskRepository.findByTopicId(topicId, pageable);
    }
}

