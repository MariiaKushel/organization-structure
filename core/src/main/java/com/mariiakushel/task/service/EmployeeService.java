package com.mariiakushel.task.service;

import com.mariiakushel.task.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto dto);

    EmployeeDto update(EmployeeDto dto);

    void deactivate(Long id);

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAll();
}
