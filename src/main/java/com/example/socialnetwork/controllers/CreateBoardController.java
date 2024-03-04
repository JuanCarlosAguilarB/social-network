package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.services.CreateBoardServices;
import com.example.socialnetwork.services.user.GetUserByUsername;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CreateBoardController {


    @Autowired
    private CreateBoardServices createBoardServices;

    @Autowired
    private GetUserByUsername getUserByUsername;

    @PostMapping("/board/")
    public ResponseEntity createBoard(@RequestBody CreateBoardRequest createBoardRequest, Authentication auth) {

        // Extract userId of token
        String username = auth.getName();
        UUID userId = getUserByUsername.getUserByUsername(username).getId();

        Board board = Board.builder()
                .name(createBoardRequest.getName())
                .description(createBoardRequest.getDescription())
                .userId(userId)
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