package com.leonardokuster.toDoList.controller;

import com.leonardokuster.toDoList.model.Task;
import com.leonardokuster.toDoList.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> saveTask(@Valid @RequestBody Task task) {
        taskService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(taskService.findAllTasks(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

    // Patch atualiza algum ou alguns campos, o Put atualiza tudo
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        taskService.updateTaskById(id, task);
        return ResponseEntity.ok().build();
    }
}