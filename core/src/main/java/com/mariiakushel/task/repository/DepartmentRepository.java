package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Interface for database operation with Department entity
 */
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    /**
     * Method gets Department by id and active.
     *
     * @param id     Department id
     * @param active active status
     * @return Optional representation of Department or empty Optional, if Department was not found
     */
    Optional<Department> findByIdAndActive(Long id, boolean active);

    /**
     * Method gets Department by name and directorate and active.
     *
     * @param name   Department name
     * @param dir    Department`s directorate
     * @param active active status
     * @return Optional representation of Department or empty Optional, if Department was not found
     */
    Optional<Department> findByNameAndDirectorateAndActive(String name, Directorate dir, boolean active);

    /**
     * Method gets all Departments by active in current range of pages.
     *
     * @param active active status
     * @param paging pagination parameters
     * @return Page of Department or empty Page if no one Department was found
     */
    Page<Department> findAllByActive(boolean active, Pageable paging);

    /**
     * Method gets all Departments by active in current range of pages.
     *
     * @param dir    Department`s directorate
     * @param active active status
     * @param paging pagination parameters
     * @return Page of Department or empty Page if no one Department was found
     */
    Page<Department> findAllByDirectorateAndActive(Directorate dir, boolean active, Pageable paging);


}
