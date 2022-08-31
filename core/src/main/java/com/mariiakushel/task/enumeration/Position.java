package com.mariiakushel.task.enumeration;

/**
 * Enum represents nomenclature position of Employee.
 * It includes dependence between position, type of subdepartment and user role.
 */
public enum Position {
    EMPLOYEE(SubdepartmentType.EMPLOYEES, UserRole.ROLE_EMPLOYEE),
    HEAD_OF_DEPARTMENT(SubdepartmentType.HEADS, UserRole.ROLE_HEAD),
    DIRECTOR_OF_DIRECTORATE(SubdepartmentType.DIRECTORS, UserRole.ROLE_DIRECTOR);

    private final SubdepartmentType subdepartmentType;
    private final UserRole role;

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
