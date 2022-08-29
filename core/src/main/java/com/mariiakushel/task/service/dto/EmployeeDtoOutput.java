package com.mariiakushel.task.service.dto;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.repository.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoOutput {
    private Long id;
    private String name;
    private String surname;
    private String personalId;
    private Integer age;
    private Position position;
    private DepartmentDtoOutput department;
}
