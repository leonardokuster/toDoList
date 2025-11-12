package com.leonardokuster.toDoList.repository;

import com.leonardokuster.toDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    // Método para filtrar por status
    List<Task> findByStatusContaining(String status);
}
