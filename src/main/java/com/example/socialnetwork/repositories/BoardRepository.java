package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
