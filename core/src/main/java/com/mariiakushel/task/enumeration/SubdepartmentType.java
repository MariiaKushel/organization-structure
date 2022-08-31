package com.mariiakushel.task.enumeration;

/**
 * Enum represents type of subdepartment.
 * It includes capacity of subdepartment to ensure that subdepartment is not overflow.
 */
public enum SubdepartmentType {
    EMPLOYEES(Integer.MAX_VALUE),
    HEADS(1),
    DIRECTORS(1);

    private final long capacity;

    SubdepartmentType(long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }
}
