package com.atthahara.dayflow.dto;

import com.atthahara.dayflow.constant.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private UUID id;
    private TaskType type;  // pastikan hanya satu field type
    private String name;    // pastikan ada field name
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private LocalDateTime startDate;
    private LocalDateTime completedDate;
    private String description;
    private String status;
    private Boolean isActive;
}
