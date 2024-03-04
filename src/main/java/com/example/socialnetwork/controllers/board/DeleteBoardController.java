package com.example.socialnetwork.controllers.board;


import com.example.socialnetwork.services.board.DeleteBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Board", description = "Board management operations")
@RestController
public class DeleteBoardController {

    @Autowired
    private DeleteBoardService deleteBoardServices;

    @Operation(summary = "Delete a board", description = "Deletes a board by its id", tags = { "Board" })
    @DeleteMapping("/board/{boardId}/")
    public ResponseEntity deleteBoard(@PathVariable UUID boardId) {
        deleteBoardServices.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

}
