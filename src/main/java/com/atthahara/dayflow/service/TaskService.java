package com.atthahara.dayflow.service;

import org.springframework.stereotype.Service;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.mapper.TaskMapper;
import com.atthahara.dayflow.model.Task;
import com.atthahara.dayflow.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO createTask(TaskRequestDTO task) {
        Task taskEntity = TaskMapper.toEntity(task);
        taskRepository.save(taskEntity);
        return TaskMapper.toResponse(taskEntity);
    }
}
