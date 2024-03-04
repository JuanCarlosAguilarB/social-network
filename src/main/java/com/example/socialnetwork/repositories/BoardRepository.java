package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
}
