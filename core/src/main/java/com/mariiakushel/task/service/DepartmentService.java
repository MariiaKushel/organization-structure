package com.mariiakushel.task.service;

import com.mariiakushel.task.service.dto.DepartmentDtoOutput;

import java.util.List;

public interface DepartmentService {

    DepartmentDtoOutput create(DepartmentDtoOutput dto);

    DepartmentDtoOutput update(DepartmentDtoOutput dto);

    void deactivate(Long id);

    DepartmentDtoOutput findById (Long id);

    List<DepartmentDtoOutput> findAll();
}
