package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBoardServices {

    @Autowired
    BoardRepository boardRepository;

    public ListBoardServices(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<Board> listBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
