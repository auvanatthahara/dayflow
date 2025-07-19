package com.atthahara.dayflow.mapper;

import java.time.LocalDate;

import com.atthahara.dayflow.constant.TaskType;
import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.dto.TaskResponseDTO;
import com.atthahara.dayflow.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setType(TaskType.fromLabel(dto.getType()));
        task.setName(dto.getName());
        task.setCreatedDate(LocalDate.now());
        task.setDueDate(dto.getDueDate());
        task.setStartDate(dto.getStartDate());
        task.setCompletedDate(dto.getCompletedDate());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);

        return task;
    }

    public static TaskResponseDTO toResponse(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setType(task.getType().getLabel());
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
