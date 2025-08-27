package com.atthahara.dayflow.controller;

import com.atthahara.dayflow.model.TaskModel;
import com.atthahara.dayflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE
    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        return taskRepository.save(task);
    }

    // READ ALL
    @GetMapping
    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable UUID id) {
        return taskRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TaskModel updateTask(@PathVariable UUID id, @RequestBody TaskModel updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setName(updatedTask.getName());
                    task.setType(updatedTask.getType());
                    task.setStatus(updatedTask.getStatus());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setStartDate(updatedTask.getStartDate());
                    task.setCompletedDate(updatedTask.getCompletedDate());
                    task.setIsActive(updatedTask.getIsActive());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskRepository.deleteById(id);
    }
}
