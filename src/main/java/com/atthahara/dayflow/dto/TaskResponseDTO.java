package com.atthahara.dayflow.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class TaskResponseDTO {

    private UUID id;
    private String type;
    private String name;

    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private LocalDateTime completedDate;

    private String description;
    private String status;
    private Boolean isActive;
}
