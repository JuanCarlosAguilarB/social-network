package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.repositories.BoardRepository;
import com.example.socialnetwork.services.ListBoardServices;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ListBoardController {

    @Autowired
    ListBoardServices listBoardServices;
    @GetMapping("/boards/")
    public ResponseEntity<Page<BoardResponse>> getBoard(Pageable pageable) {
            Page<Board> boardPage = listBoardServices.listBoards(pageable);

            Page<BoardResponse> boardResponsePage = boardPage.map(board -> BoardResponse.builder()
                    .id(board.getId())
                    .name(board.getName())
//                    .tasks(board.getTasks())
                    .build());


            return ResponseEntity.ok(boardResponsePage);
    }

}

@Builder
@Getter
class BoardResponse {
    private UUID id;
    private String name;
    private List<Task> tasks;
}