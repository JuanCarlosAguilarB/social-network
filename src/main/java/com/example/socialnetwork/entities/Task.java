package com.example.socialnetwork.entities;

import com.example.socialnetwork.dto.StatusDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    @Column(name = "status_id")
    private Integer statusId;

//    @Column(name = "board_id")
//    private Integer boardId;
    @Column(name = "topic_id")
    private UUID topicId;




    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus_id() {
        return statusId;
    }


    public StatusDTO getStatus() {
        return StatusDTO.builder()
                .id(statusId)
                .name(status.getName())
                .build();
    }

//    public Board getBoard() {
//        return board;
//    }

//    @ManyToOne
//    @JoinColumn(name = "board_id", insertable = false, updatable = false)
//    private Board board;

    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private Status status;
}
