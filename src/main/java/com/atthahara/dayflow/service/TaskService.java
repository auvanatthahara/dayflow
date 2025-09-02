package com.atthahara.dayflow.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.mapper.TaskMapper;
import com.atthahara.dayflow.model.Task;
import com.atthahara.dayflow.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create Task
    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {
        Task task = TaskMapper.toEntity(requestDTO);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toResponse(savedTask);
    }

    // Get Task by ID
    public TaskResponseDTO getTaskById(String id) {
        Task task = taskRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        return TaskMapper.toResponse(task);
    }
}