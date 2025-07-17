package com.atthahara.dayflow.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {

    @NotNull
    private String type;

    @NotNull
    private String name;

    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private LocalDateTime completedDate;

    private String description;

    @NotNull
    private String status;

    private Boolean isActive;
}
