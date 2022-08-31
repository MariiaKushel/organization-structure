package com.mariiakushel.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class represents a Department DTO for output operations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDtoOutput {
    private Long id;
    private String name;
    private String description;
    private DirectorateDtoOutput directorate;
}
