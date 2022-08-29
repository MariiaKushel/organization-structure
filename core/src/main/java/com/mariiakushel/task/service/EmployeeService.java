package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;

import java.util.List;

public interface EmployeeService {

    EmployeeDtoOutput create(Long idDep, EmployeeDtoInputCreate dto) throws CustomException;

    EmployeeDtoOutput update(Long id, EmployeeDtoInputUpdate dto) throws CustomException;

    void deactivate(Long id) throws CustomException;

    EmployeeDtoOutput findById(Long id) throws CustomException;

    List<EmployeeDtoOutput> findAll(int page, int size);

    List<EmployeeDtoOutput> findAllByDepartment(Long idDep, int page, int size);

    List<EmployeeDtoOutput> findAllByDirectorate(Long idDir, int page, int size);
}
