package com.atthahara.dayflow.mapper;

import java.time.LocalDateTime;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.model.TaskModel;

public class TaskMapper {

    public static TaskModel toEntity(TaskRequestDTO dto) {
        TaskModel task = new TaskModel();
        task.setType(dto.getType());
        task.setName(dto.getName());
        task.setCreatedDate(LocalDateTime.now());
        task.setDueDate(dto.getDueDate());
        task.setStartDate(dto.getStartDate());
        task.setCompletedDate(dto.getCompletedDate());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);

        return task;
    }

    public static TaskResponseDTO toResponse(TaskModel task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setType(task.getType());
        dto.setName(task.getName());
        dto.setCreatedDate(task.getCreatedDate());
        dto.setDueDate(task.getDueDate());
        dto.setStartDate(task.getStartDate());
        dto.setCompletedDate(task.getCompletedDate());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setIsActive(task.getIsActive());

        return dto;
    }
}
