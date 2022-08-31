package com.mariiakushel.task.service.dto;

import com.mariiakushel.task.enumeration.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Class represents a Employee DTO for creation operation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoInputCreate {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(min = 11, max = 11)
    private String personalId;
    @Positive
    @Min(18)
    @Max(99)
    private Integer age;
    private Position position;
}
