package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.DirectorateDtoInput;
import com.mariiakushel.task.service.dto.DirectorateDtoOutput;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface represents business logic for work with Directorate
 */
public interface DirectorateService {

    /**
     * Method creates new Directorate. As well, it creates a default Department and Subdepartment for Director of Directorate.
     *
     * @param dto DTO representation of new Directorate
     * @return DTO representation of created Directorate
     * @throws CustomException if Directorate with such name already exist.
     */
    DirectorateDtoOutput create(@Valid DirectorateDtoInput dto) throws CustomException;

    /**
     * Method updates active Directorate.
     *
     * @param id  Directorate id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Directorate
     * @throws CustomException if Directorate was not found by id or
     *                         if Directorate with such name already exist .
     */
    DirectorateDtoOutput update(Long id, @Valid DirectorateDtoInput dto) throws CustomException;

    /**
     * Method deactivates active Directorate. As well, it deactivates included Departments and Subdeparments.
     *
     * @param id Directorate id
     * @throws CustomException if Directorate was not found by id  or
     *                         if there are present active Employees at Directorate.
     */
    void deactivate(Long id) throws CustomException;

    /**
     * Method finds active Directorate by id
     *
     * @param id id Directorate id
     * @return DTO representation of Directorate
     * @throws CustomException if Directorate was not found by id
     */
    DirectorateDtoOutput findById(Long id) throws CustomException;

    /**
     * Method finds all active Directorates with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Directorates or empty List, if no one Directorates was found.
     */
    List<DirectorateDtoOutput> findAll(int page, int size);
}
