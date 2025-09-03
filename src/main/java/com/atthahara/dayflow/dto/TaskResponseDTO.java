package com.atthahara.dayflow.dto;

import com.atthahara.dayflow.constant.TaskType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TaskResponseDTO {

    private UUID id;
    private TaskType type;
    private String name;
    private String description;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private LocalDateTime completedDate;
}
