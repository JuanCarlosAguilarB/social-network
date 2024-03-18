package com.example.socialnetwork.controllers.board;

import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.entities.TaskListDTO;
import com.example.socialnetwork.entities.Topic;
import com.example.socialnetwork.entities.TopicListDTO;
import com.example.socialnetwork.repositories.board.TopicRepository;
import com.example.socialnetwork.services.board.GetTopicsOfBoardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@Tag(name = "Board", description = "Boards management operations")
public class GetTopicsOfBoardController {

    @Autowired
    private GetTopicsOfBoardService getTopicsOfBoardService;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/boards/{boardId}/topics/")
    public ResponseEntity getTopicsOfBoard(@PathVariable UUID boardId, Pageable pageable) {
        log.info("Get topics of board controller");

        List<TopicListDTO> topics = getTopicsOfBoardService.getTopicsOfBoard(boardId, pageable);


        return ResponseEntity.ok(topics);
    }


}


@Data
@AllArgsConstructor
@NoArgsConstructor
class TopicDTO {
    private UUID id;
    private String name;
    //    private String color;
    private List<Task> tasks; // Lista de tareas como atributo
    // Constructor, getters y setters
}
