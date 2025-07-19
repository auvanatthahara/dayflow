package com.atthahara.dayflow.constant;

public enum TaskType {
    PERSONAL("Personal"),
    WORK("Work"),
    STUDY("Study"),
    OTHER("Other");

    private final String label;

    TaskType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TaskType fromLabel(String label) {
        for (TaskType type : TaskType.values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TaskType: " + label);
    }

}
