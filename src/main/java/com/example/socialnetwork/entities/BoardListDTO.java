package com.example.socialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BoardListDTO {

    private UUID id;
    private String name;
}

