package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.entities.BoardListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {

    public void deleteById(UUID boardId);

    public boolean existsById(UUID boardId);

    public Page<BoardListDTO>  findBy(Pageable pageable);

}
