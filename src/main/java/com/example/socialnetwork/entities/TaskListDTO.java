package com.example.socialnetwork.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskListDTO {

    private UUID id;
    private String name;
    private String description;
    private Integer statusId;
//    private Status status;
}
