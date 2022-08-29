package com.mariiakushel.task.service.dto;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.repository.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoInputUpdate {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Positive
    @Min(18)
    @Max(99)
    private Integer age;
    private Position position;
    @Positive
    private Long departmentId;
}
