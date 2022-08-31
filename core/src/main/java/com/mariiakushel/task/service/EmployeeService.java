package com.mariiakushel.task.service;

import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.service.dto.EmployeeDtoInputCreate;
import com.mariiakushel.task.service.dto.EmployeeDtoInputUpdate;
import com.mariiakushel.task.service.dto.EmployeeDtoOutput;

import java.util.List;

/**
 * Interface represents business logic for work with Employee
 */
public interface EmployeeService {

    /**
     * Method creates new Employee. As well, it creates new User corresponding that Employee.
     *
     * @param idDep Department id which is new Employee owner
     * @param dto   DTO representation of new Employee
     * @return DTO representation of created Employee
     * @throws CustomException if Department by id was not found or
     *                         if Employee with such personal id already exist or
     *                         if Employee`s position is not present in such Department or
     *                         if position capacity is overflow.
     */
    EmployeeDtoOutput create(Long idDep, EmployeeDtoInputCreate dto) throws CustomException;

    /**
     * Method updates active Employee. Employee`s personal id must not change.
     *
     * @param id  Employee id
     * @param dto DTO representation of data for update
     * @return DTO representation of updated Employee
     * @throws CustomException if Employee by id was not found or
     *                         if new Department by id was not found or
     *                         if Employee`s position is not present in such Department or
     *                         if position capacity is overflow.
     */
    EmployeeDtoOutput update(Long id, EmployeeDtoInputUpdate dto) throws CustomException;

    /**
     * Method deactivates active Employee. As well, it deactivates corresponding User.
     *
     * @param id Employee id
     * @throws CustomException if Employee by id was not found
     */
    void deactivate(Long id) throws CustomException;

    /**
     * Method finds active Employee by id
     *
     * @param id Employee id
     * @return DTO representation of Employee
     * @throws CustomException if Employee by id was not found
     */
    EmployeeDtoOutput findById(Long id) throws CustomException;

    /**
     * Method finds all active Employees with pagination.
     *
     * @param page number of page
     * @param size page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     */
    List<EmployeeDtoOutput> findAll(int page, int size);

    /**
     * Method finds all active Employees by Department with pagination.
     *
     * @param idHead id of Head of Department
     * @param page   number of page
     * @param size   page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     * @throws CustomException if Head of Department by id was not found
     */
    List<EmployeeDtoOutput> findAllByDepartment(Long idHead, int page, int size) throws CustomException;

    /**
     * Method finds all active Employees by Directorate with pagination.
     *
     * @param idDirector id of Director of Directorate
     * @param page       number of page
     * @param size       page size
     * @return List of DTO representation of Employees or empty List, if no one Employees was found.
     * @throws CustomException if Director of Directorate by id was not found
     */
    List<EmployeeDtoOutput> findAllByDirectorate(Long idDirector, int page, int size) throws CustomException;
}
