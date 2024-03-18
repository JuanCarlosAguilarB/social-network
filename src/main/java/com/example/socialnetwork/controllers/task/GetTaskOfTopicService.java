package com.example.socialnetwork.controllers.task;

import com.example.socialnetwork.entities.TaskListDTO;
import com.example.socialnetwork.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class GetTaskOfTopicService {

    @Autowired
    private TaskRepository taskRepository;

    public Page<TaskListDTO> getTaskOfTopic(UUID topicId, Pageable pageable) {
        log.info("Getting tasks of  topic with id: " + topicId);

        // TODO: refactorizar, el principal problema esque estamos usando un repositorio del modulo de task en el modulo de Topic
        // debemos buscar la forma de como implementar esto correctamente, no se si crear un servicio en topic y llamar a este

        List<TaskListDTO> tasks = taskRepository.findByTopicId(topicId, pageable);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), tasks.size());

        Page<TaskListDTO> taskPaginated = new PageImpl<>(tasks.subList(start, end), pageable, tasks.size());

        return taskPaginated;
    }
}
