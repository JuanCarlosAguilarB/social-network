package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.entities.Topic;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//@RestController
public class ListBoardController {

    @Autowired
    ListBoardServices listBoardServices;
//    @GetMapping("/boards/")
//    public ResponseEntity getBoard(Pageable pageable) {
////            Page<Board> boardPage = listBoardServices.listBoards(pageable);
//
//        List<Topic> topics = new ArrayList<>();
//        boardPage.stream().map(board ->  topics.add(board.getTopics().get(0)));
//
////            Page<BoardResponse> boardResponsePage = boardPage.map(board -> BoardResponse.builder()
////                    .id(board.getId())
////                    .name(board.getName())
////                    .userId(board.getUserId())
////                    .description(board.getDescription())
////                    .tasks(board.getTopics())
////                    .build());
//
////            return ResponseEntity.ok(boardResponsePage);
//            return ResponseEntity.ok(boardPage);
//    }
//
}

@Builder
@Getter
class BoardResponse {
    private UUID id;
    private UUID userId;
    private String name;
    private String description;
    private List<Topic> tasks;
}