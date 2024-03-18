package com.example.socialnetwork.repositories.board;

import com.example.socialnetwork.entities.Color;
import com.example.socialnetwork.entities.Task;
import com.example.socialnetwork.entities.Topic;
import com.example.socialnetwork.entities.TopicListDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {


//    List<TopicListDTO1> findByBoardId( UUID boardId);

    @Query("SELECT new com.example.socialnetwork.entities.TopicListDTO(t.id, t.name, t.description, t.color) FROM Topic t WHERE t.boardId = :boardId")
    List<TopicListDTO> findByBoardIdCustom(UUID boardId);
}

