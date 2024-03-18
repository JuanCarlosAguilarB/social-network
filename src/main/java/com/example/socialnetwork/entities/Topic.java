package com.example.socialnetwork.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @Column(name = "color_id")
    private Integer colorId;


    @Column(name = "board_id")
    private UUID boardId;

    @ManyToOne
    @JoinColumn(name = "board_id", insertable = false, updatable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "color_id", insertable = false, updatable = false)
    private Color color;

    @OneToMany(mappedBy = "topicId", cascade = CascadeType.ALL)
    private List<Task> tasks;

}