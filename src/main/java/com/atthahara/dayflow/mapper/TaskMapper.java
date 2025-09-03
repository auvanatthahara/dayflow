package com.atthahara.dayflow.mapper;

import com.atthahara.dayflow.dto.TaskRequestDTO;
import com.atthahara.dayflow.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {
        if (dto == null) return null;

        Task task = new Task();
        task.setName(dto.getName());
        task.setType(dto.getType());
        task.setStartDate(dto.getStartDate());
        task.setEndDate(dto.getEndDate());
        task.setCreatedDate(java.time.LocalDateTime.now()); // selalu set saat create
        return task;
    }
}
