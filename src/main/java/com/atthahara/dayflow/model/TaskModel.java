package com.atthahara.dayflow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator; // <-- penting, dari Hibernate

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
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