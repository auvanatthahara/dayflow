package com.atthahara.dayflow.service;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.mapper.TaskMapper;
import com.atthahara.dayflow.model.Task;
import com.atthahara.dayflow.constant.TaskType;
import com.atthahara.dayflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /** CREATE */
    public Task createTask(TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        task.setCreatedDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /** READ - all */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /** READ - by id */
    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    /** UPDATE */
    public Optional<Task> updateTask(UUID id, TaskRequestDTO dto) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setName(dto.getName());
            existingTask.setType(dto.getType());
            existingTask.setStartDate(dto.getStartDate());
            existingTask.setEndDate(dto.getEndDate());
            return taskRepository.save(existingTask);
        });
    }

    /** DELETE */
    public boolean deleteTask(UUID id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /** FILTER by type */
    public List<Task> getTasksByType(TaskType type) {
        return taskRepository.findByType(type);
    }
}
