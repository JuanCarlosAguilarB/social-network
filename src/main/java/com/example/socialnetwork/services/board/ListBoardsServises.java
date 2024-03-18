package com.example.socialnetwork.services.board;

import com.example.socialnetwork.entities.Board;
import com.example.socialnetwork.entities.BoardListDTO;
import com.example.socialnetwork.repositories.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListBoardsServises {

    @Autowired
    private BoardRepository boardRepository;

//    public Page<Board> listBoards(Pageable pageable) {
//        log.info("List boards service");
//        return boardRepository.findAll(pageable);
//    }

    public Page<BoardListDTO> listBoards (Pageable pageable) {
        log.info("List boards service");
        return boardRepository.findBy(pageable);
    }

}

@Data
@AllArgsConstructor
class BoardList {

    private String name;
}