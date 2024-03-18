package com.example.socialnetwork.services.board;

import com.example.socialnetwork.controllers.task.GetTaskForBoardService;
import com.example.socialnetwork.entities.TopicListDTO;
import com.example.socialnetwork.repositories.board.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetTopicsOfBoardService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    GetTaskForBoardService getTaskForBoard;

    public List<TopicListDTO> getTopicsOfBoard(UUID boardId, Pageable pageable) {

        List<TopicListDTO> topics = topicRepository.findByBoardIdCustom(boardId);

        int pageNumber = 0;
        int pageSize = 5;

//        Pageable pageable1 = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        Pageable pageableTask =  PageRequest.of(pageNumber, pageSize);


        for (TopicListDTO topic : topics) {
            topic.setTasks(getTaskForBoard.getTaskForBoard(topic.getId(), pageableTask));
        }
        return topics;
    }

}


