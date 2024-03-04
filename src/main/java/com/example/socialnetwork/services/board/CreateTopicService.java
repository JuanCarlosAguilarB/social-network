package com.example.socialnetwork.services.board;

import com.example.socialnetwork.entities.Topic;
import com.example.socialnetwork.repositories.board.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTopicService {

    @Autowired
    private TopicRepository topicRepository;

    public void createTopic(Topic topic) {

        topicRepository.save(topic);

    }
}
