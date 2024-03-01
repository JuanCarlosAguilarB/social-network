package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.services.CreateBoardServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBoardController {


    @Autowired
    private CreateBoardServices createBoardServices;


    @PostMapping("/board/")
    public ResponseEntity createBoard(@RequestBody CreateBoardRequest createBoardRequest) {

        Board board = Board.builder()
                .name(createBoardRequest.getName())
                .description(createBoardRequest.getDescription())
                .build();

        createBoardServices.createBoard(
                board
        );
        return ResponseEntity.ok().build();
    }

}

@Getter
@Setter
class CreateBoardRequest {
    private String name;
    private String description;
}