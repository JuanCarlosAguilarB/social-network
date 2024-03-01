package com.example.socialnetwork.services;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.exceptions.ResourceNotCreatedException;
import com.example.socialnetwork.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateBoardServices {

    @Autowired
    BoardRepository boardRepository;

     public void createBoard(Board board) {
         try {
             boardRepository.save(board);
         } catch (Exception e) {
             throw new ResourceNotCreatedException("Error creating board");
         }
     }
}
