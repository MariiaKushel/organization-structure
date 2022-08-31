package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.DepartmentDtoInput;
import com.mariiakushel.task.service.dto.DepartmentDtoOutput;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface represents business logic for work with Department
 */
public interface DepartmentService {
    /**
     * Method creates new Department. As well, it create two Subdepartments - for Heads of Department and Employees.
     *
     * @param idDir Directorate id which  is new Department owner
     * @param dto   DTO representation of new Department
     * @return DTO representation of created Department
     * @throws CustomException if Directorate by id was not found or
     *                         if Department with such name already exist in that Directorate.
     */
    DepartmentDtoOutput create(Long idDir, @Valid DepartmentDtoInput dto) throws CustomException;

    /**
     * Method updates active Department.
     *
     * @param id  Department id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Department
     * @throws CustomException if Department was not found by id or
     *                         if Department with such name already exist in that Directorate.
     */
    DepartmentDtoOutput update(Long id, @Valid DepartmentDtoInput dto) throws CustomException;

    /**
     * Method deactivates active Department. As well, it deactivates included Subdeparments.
     *
     * @param id Department id
     * @throws CustomException if Department was not found by id  or
     *                         if there are present active Employees at Department.
     */
    void deactivate(Long id) throws CustomException;

    /**
     * Method finds active Department by id
     *
     * @param id Department id
     * @return DTO representation of Department
     * @throws CustomException if Department was not found by id
     */
    DepartmentDtoOutput findById(Long id) throws CustomException;

    /**
     * Method finds all active Departments with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Departments or empty List, if no one Department was found.
     */
    List<DepartmentDtoOutput> findAll(int page, int size);

    /**
     * Method finds all active Departments by Directorate with pagination.
     *
     * @param idDir Directorate id which  is new Department owner
     * @param page  number of page
     * @param size  page size
     * @return List of DTO representation of Departments or empty List, if no one Department was found.
     */
    List<DepartmentDtoOutput> findAllByDirectorate(Long idDir, int page, int size);
}
