package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.services.CreateBoardServices;
import com.example.socialnetwork.services.user.GetUserByUsername;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Board", description = "Board management operations")
@RestController
public class CreateBoardController {


    @Autowired
    private CreateBoardServices createBoardServices;

    @Autowired
    private GetUserByUsername getUserByUsername;

    @Operation(summary = "Create a new board", description = "Creates a new board for the authenticated user", tags = { "Board" })
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
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

@Getter
@Setter
class CreateBoardRequest {
    private String name;
    private String description;
}