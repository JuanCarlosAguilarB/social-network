package com.example.socialnetwork.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false, unique = false)
    private String name;

    private String description;

    @Column(nullable = false, unique = false, name="user_id")
    private UUID userId;


    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @JsonIgnoreProperties("board") // to avoid infinite recursion by circular imports
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Topic> topics;

    // relations
//    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Task> tasks;





}
