package com.mariiakushel.task.enumeration;

import com.mariiakushel.task.repository.entity.Subdepartment;

public enum Position {
    EMPLOYEE(SubdepartmentType.EMPLOYEES),
    HEAD_OF_DEPARTMENT(SubdepartmentType.HEADS),
    DIRECTOR_OF_DIRECTORATE(SubdepartmentType.DIRECTORS);

    private SubdepartmentType subdepartmentType;

    Position(SubdepartmentType subdepartmentType) {
        this.subdepartmentType = subdepartmentType;
    }

    public SubdepartmentType getSubdepartmentType() {
        return subdepartmentType;
    }
}
