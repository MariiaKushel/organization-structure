package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.Subdepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Interface for database operation with Employee entity
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    /**
     * Method gets Employee by id and active.
     *
     * @param id     Employee id
     * @param active active status
     * @return Optional representation of Employee or empty Optional, if Employee was not found
     */
    Optional<Employee> findByIdAndActive(Long id, boolean active);

    /**
     * Method gets Employee by personal id and active.
     *
     * @param personalId Employee personal id
     * @param active     active status
     * @return Optional representation of Employee or empty Optional, if Employee was not found
     */
    Optional<Employee> findByPersonalIdAndActive(String personalId, boolean active);

    /**
     * Method gets all Employees by active in current range of pages.
     *
     * @param active active status
     * @param paging pagination parameters
     * @return Page of Employees or empty Page if no one Employee was found
     */
    Page<Employee> findAllByActive(boolean active, Pageable paging);

    /**
     * Method gets all Employees by active and Department in current range of pages.
     *
     * @param active     active status
     * @param department department
     * @param paging     pagination parameters
     * @return List of Employees or empty List if no one Employee was found
     */
    List<Employee> findAllByActiveAndSubdepartmentDepartment(boolean active, Department department, Pageable paging);

    /**
     * Method gets all Employees by active and Directorate in current range of pages.
     *
     * @param active      active status
     * @param directorate directorate
     * @param paging      pagination parameters
     * @return List of Employees or empty List if no one Employee was found
     */
    List<Employee> findAllByActiveAndSubdepartmentDepartmentDirectorate(boolean active, Directorate directorate,
                                                                        Pageable paging);

    /**
     * Method counts all Employees by active and Directorate.
     *
     * @param active      active status
     * @param directorate directorate
     * @return quantity of Employees or 0 if no one Employee was found
     */
    long countByActiveAndSubdepartmentDepartmentDirectorate(boolean active, Directorate directorate);

    /**
     * Method counts all Employees by active and Department.
     *
     * @param active     active status
     * @param department department id
     * @return quantity of Employees or 0 if no one Employee was found
     */
    long countByActiveAndSubdepartmentDepartment(boolean active, Department department);

    /**
     * Method counts all Employees by active and subdepartment.
     *
     * @param active        active status
     * @param subdepartment subdepartment
     * @return quantity of Employees or 0 if no one Employee was found
     */
    long countByActiveAndSubdepartment(boolean active, Subdepartment subdepartment);
}
