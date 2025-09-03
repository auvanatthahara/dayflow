package com.atthahara.dayflow.dto;

import com.atthahara.dayflow.constant.TaskType;
import java.time.LocalDateTime;

public class TaskRequestDTO {
    private String name;
    private TaskType type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public TaskType getType() { return type; }
    public void setType(TaskType type) { this.type = type; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
}
