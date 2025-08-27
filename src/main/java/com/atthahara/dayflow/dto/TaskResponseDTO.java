package com.atthahara.dayflow.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class TaskResponseDTO {

    private UUID id;
    private String type;
    private String name;

    private LocalDate createdDate;
    private LocalDate dueDate;
    private LocalDate startDate;
    private LocalDate completedDate;

    private String description;
    private String status;
    private Boolean isActive;
}
