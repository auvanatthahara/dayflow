package com.atthahara.dayflow.model;

import java.time.LocalDate;
import java.util.UUID;

import com.atthahara.dayflow.constant.TaskType;

>>>>>>> origin/master:src/main/java/com/atthahara/dayflow/model/Task.java
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator; // <-- penting, dari Hibernate

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskType type;

    @NotNull
    private String name;

    @NotNull
    private LocalDate createdDate;

    private LocalDate dueDate;

    private LocalDate startDate;

    private LocalDate completedDate;

    private String description;

    @NotNull
    private String status;

    private Boolean isActive;
}