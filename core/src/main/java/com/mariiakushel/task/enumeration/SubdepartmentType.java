package com.mariiakushel.task.enumeration;

public enum SubdepartmentType {
    EMPLOYEES(Integer.MAX_VALUE),
    HEADS(1),
    DIRECTORS(1);

    private long capacity;

    SubdepartmentType(long capacity) {
        this.capacity = capacity;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
}
