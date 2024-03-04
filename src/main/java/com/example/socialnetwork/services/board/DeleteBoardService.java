package com.example.socialnetwork.services.board;

import com.example.socialnetwork.exceptions.BoardNotFound;
import com.example.socialnetwork.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteBoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void deleteBoard(UUID boardId) {

        if (!boardRepository.existsById(boardId)) {
            throw new BoardNotFound("Error deleting board: Board not found");
        }

        boardRepository.deleteById(boardId);

    }
}
