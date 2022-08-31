package com.mariiakushel.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Class represents a Department DTO for input operations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDtoInput {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
