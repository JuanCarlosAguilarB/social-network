package com.example.socialnetwork.entities;

import com.example.socialnetwork.dto.StatusDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
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

    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    @Column(name = "topic_id")
    private UUID topicId;

    public StatusDTO getStatus() {
        return StatusDTO.builder()
                .id(statusId)
                .name(status.getName())
                .build();
    }


    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY) // Asegúrate de configurar correctamente el fetch type según tus necesidades
    @JoinColumn(name = "topic_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Topic topic;
}



//
//public class Task {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    private String name;
//    private String description;
//
//    @Column(name = "status_id", nullable = false)
//    private Integer statusId;
//
//    @Column(name = "board_id")
//    private Integer boardId;
//    @Column(name = "topic_id")
//    private UUID topicId;
//
//
//
//    public StatusDTO getStatus() {
//        return StatusDTO.builder()
//                .id(statusId)
//                .name(status.getName())
//                .build();
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "board_id", insertable = false, updatable = false)
//    private Board board;
//
//    @ManyToOne
//    @JoinColumn(name = "status_id", insertable = false, updatable = false)
//    private Status status;
//
//    @ManyToOne(fetch = FetchType.LAZY) // Asegúrate de configurar correctamente el fetch type según tus necesidades
//    @JoinColumn(name = "topic_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Topic topic;
//}
