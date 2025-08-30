package com.atthahara.dayflow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.service.TaskService;

import jakarta.validation.Valid;

@RestController   // <- pakai RestController biar default return JSON
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Dependency Injection lewat constructor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create Task
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO taskRequest) {
        TaskResponseDTO response = taskService.createTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get Task by ID (contoh pakai RequestParam, bukan di path)
    @GetMapping
    public ResponseEntity<TaskResponseDTO> getTaskById(@RequestParam("id") String id) {
        TaskResponseDTO response = taskService.getTaskById(id);
        return ResponseEntity.ok(response); // 200 OK
    }
}
