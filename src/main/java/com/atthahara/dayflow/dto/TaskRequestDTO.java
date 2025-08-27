package com.atthahara.dayflow.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {

    @NotNull
    private String type;

    @NotNull
    private String name;

    private LocalDate dueDate;
    private LocalDate startDate;
    private LocalDate completedDate;

    private String description;

    @NotNull
    private String status;

    private Boolean isActive;
}
