package com.mariiakushel.task.enumeration;

import com.mariiakushel.task.repository.entity.Subdepartment;

public enum Position {
    EMPLOYEE(SubdepartmentType.EMPLOYEES, UserRole.ROLE_EMPLOYEE),
    HEAD_OF_DEPARTMENT(SubdepartmentType.HEADS, UserRole.ROLE_HEAD),
    DIRECTOR_OF_DIRECTORATE(SubdepartmentType.DIRECTORS, UserRole.ROLE_DIRECTOR);

    private SubdepartmentType subdepartmentType;
    private UserRole role;

    Position(SubdepartmentType subdepartmentType, UserRole role) {
        this.subdepartmentType = subdepartmentType;
        this.role = role;
    }

    public SubdepartmentType getSubdepartmentType() {
        return subdepartmentType;
    }

    public UserRole getRole() {
        return role;
    }
}
