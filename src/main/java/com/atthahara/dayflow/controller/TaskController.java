package com.atthahara.dayflow.controller;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.model.Task;
import com.atthahara.dayflow.constant.TaskType;
import com.atthahara.dayflow.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /** CREATE */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO dto) {
        Task task = taskService.createTask(dto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    /** READ - all */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    /** READ - by id */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID id) {
        Optional<Task> taskOpt = taskService.getTaskById(id);
        return taskOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** UPDATE */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id, @RequestBody TaskRequestDTO dto) {
        Optional<Task> updatedTask = taskService.updateTask(id, dto);
        return updatedTask.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** DELETE */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        boolean deleted = taskService.deleteTask(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /** FILTER by type */
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Task>> getTasksByType(@PathVariable TaskType type) {
        List<Task> tasks = taskService.getTasksByType(type);
        return ResponseEntity.ok(tasks);
    }
}
