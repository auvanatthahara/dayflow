package com.atthahara.dayflow.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class TaskModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    private LocalDateTime createdDate;

    private LocalDateTime dueDate;

    private LocalDateTime startDate;

    private LocalDateTime completedDate;

    private String description;

    @NotNull
    private String status;

    @NotNull
    private Boolean isActive;

}
