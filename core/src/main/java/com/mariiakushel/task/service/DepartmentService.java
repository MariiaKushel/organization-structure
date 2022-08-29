package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

public interface DepartmentService {

    DepartmentDtoOutput create(Long idDir, @Valid DepartmentDtoInput dto) throws CustomException;

    DepartmentDtoOutput update(Long idDir, Long id, @Valid DepartmentDtoInput dto) throws CustomException;

    void deactivate(Long idDir, Long id) throws CustomException;

    DepartmentDtoOutput findByIdByDirectorate(Long idDir, Long id) throws CustomException;

    List<DepartmentDtoOutput> findAllByDirectorate(Long idDir, int page, int size);
}
