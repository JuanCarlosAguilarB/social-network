package com.example.socialnetwork.controllers.board;

import com.example.socialnetwork.services.board.ListBoardsServises;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Tag(name = "Board", description = "Boards management operations")
public class ListBoardsController {

    @Autowired
    private ListBoardsServises listBoardsServises;

    @GetMapping("/boards/")
    @Operation(summary = "List boards", description = "List all boards", tags = { "Boards" })
    public ResponseEntity listBoards(Pageable pageable) {
        log.info("List boards controller");
        return ResponseEntity.ok(listBoardsServises.listBoards(pageable));
    }

}
