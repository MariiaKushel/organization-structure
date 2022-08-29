package com.mariiakushel.task.service.dto;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.repository.entity.Subdepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String surname;
    private String personalId;
    private Integer age;
    private Position position;
}
