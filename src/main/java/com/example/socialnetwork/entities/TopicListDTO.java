package com.example.socialnetwork.entities;


import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TopicListDTO {

    private UUID id;
    private String name;
    private String description;
    private Color color;
    private List<TaskListDTO> tasks;


    public TopicListDTO(UUID id, String name, String description, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
//        this.tasks = tasks;
    }
}
