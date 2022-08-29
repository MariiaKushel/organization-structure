package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;

import javax.validation.Valid;
import java.util.List;

public interface DirectorateService {

    DirectorateDtoOutput create(@Valid DirectorateDtoInput dto) throws CustomException;

    DirectorateDtoOutput update(Long id, @Valid DirectorateDtoInput dto) throws CustomException;

    void deactivate(Long id) throws CustomException;

    DirectorateDtoOutput findById(Long id) throws CustomException;

    List<DirectorateDtoOutput> findAll(int page, int size);
}
