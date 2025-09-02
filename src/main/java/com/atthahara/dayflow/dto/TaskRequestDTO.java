package com.atthahara.dayflow.dto;

import com.atthahara.dayflow.constant.TaskType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    @NotNull
    private TaskType type;

    @NotNull
    private String name;

    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private String description;
    private String status;
}
