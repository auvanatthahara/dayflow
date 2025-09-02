package com.atthahara.dayflow.mapper;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.model.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskMapper {

    // Convert TaskRequestDTO to Task entity
    public static Task toEntity(TaskRequestDTO dto) {
        if (dto == null) return null;

        Task task = new Task();
        task.setType(dto.getType());
        task.setName(dto.getName());
        task.setCreatedDate(LocalDate.now()); // convert to LocalDate
        task.setStartDate(dto.getStartDate() != null ? dto.getStartDate().toLocalDate() : null);
        task.setDueDate(dto.getDueDate() != null ? dto.getDueDate().toLocalDate() : null);
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setIsActive(true);

        return task;
    }

    // Convert Task entity to TaskResponseDTO
    public static TaskResponseDTO toResponse(Task task) {
        if (task == null) return null;

        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setType(task.getType());
        dto.setName(task.getName());
        dto.setCreatedDate(task.getCreatedDate() != null ? task.getCreatedDate().atStartOfDay() : null);
        dto.setStartDate(task.getStartDate() != null ? task.getStartDate().atStartOfDay() : null);
        dto.setDueDate(task.getDueDate() != null ? task.getDueDate().atStartOfDay() : null);
        dto.setCompletedDate(task.getCompletedDate() != null ? task.getCompletedDate().atStartOfDay() : null);
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setIsActive(task.getIsActive());

        return dto;
    }
}
