package com.example.socialnetwork.services.board;


import com.example.socialnetwork.repositories.board.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteTopicService {

    @Autowired
    TopicRepository topicRepository;

    public void deleteTopic(UUID id) {

        topicRepository.deleteById(id);
    }

}
