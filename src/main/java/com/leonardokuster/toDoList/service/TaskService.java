package com.leonardokuster.toDoList.service;

import com.leonardokuster.toDoList.model.Task;
import com.leonardokuster.toDoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    // Dessa forma (ao contrário de public void) retorna os dados, com isso consigo ver o id
    public Task saveTask(Task task) {
        return repository.saveAndFlush(task);
    }

    public List<Task> findAllTasks(String status) {

        if (status != null && !status.trim().isEmpty()) {
            return repository.findByStatusContaining(status);
        } else {
            return repository.findAll();
        }
    }

    public Task findTaskById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task não encontrada")
        );
    }

    public void deleteTaskById(Integer id) {
        repository.deleteById(id);
    }

    public void updateTaskById(Integer id, Task task) {
        Task existingTask = repository.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrada"));

        // Caso não atualize algum dado, irá buscar e manter o que já está no banco de dados
        Task updatedTask = Task.builder()
                .title(task.getTitle() != null ? task.getTitle() : existingTask.getTitle())
                .description(task.getDescription() != null ? task.getDescription() : existingTask.getDescription())
                .status(task.getStatus() != null ? task.getStatus() : existingTask.getStatus())
                .id(existingTask.getId())
                .build();
        repository.save(updatedTask);
    }
}
