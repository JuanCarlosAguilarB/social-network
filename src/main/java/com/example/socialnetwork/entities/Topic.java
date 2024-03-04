package com.example.socialnetwork.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    private String color;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "board_id")
    private UUID boardId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id", insertable = false, updatable = false)
    private Board board;

}
