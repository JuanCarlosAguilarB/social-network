package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository  extends JpaRepository<Task, UUID> {

    public List<Task> findByBoardId(int id);

    public Page<Task> findByBoardId(int id, Pageable pageable);
}
