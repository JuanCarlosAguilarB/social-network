package com.example.socialnetwork.controllers.board;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.repositories.BoardRepository;
import com.example.socialnetwork.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskofBoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/boards/{boardId}/tasks")
    public ResponseEntity getAllTasksOfBoard(@PathVariable Integer boardId, Pageable pageable) {
        // Obtiene el usuario autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Nombre de usuario

        // Verificar si el usuario tiene acceso a la board
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!board.getUser().getUsername().equals(username)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // Obtener todas las tareas de la junta (board)
        Page<Task> tasks = taskRepository.findByBoardId(board.getId(), pageable);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}


