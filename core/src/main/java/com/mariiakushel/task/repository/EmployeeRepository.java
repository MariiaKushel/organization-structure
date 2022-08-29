package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {


    Optional<Employee> findByIdAndActive(Long id, boolean active);

    Optional<Employee> findByPersonalIdAndActive(String personalId, boolean active);

    Page<Employee> findAllByActive(boolean active, Pageable paging);

    List<Employee> findAllByActiveAndDepartment(boolean active, Long idDep, Pageable paging);

    List<Employee> findAllByActiveAndDirectorate(boolean active, Long idDir, Pageable paging);

    long countByActiveAndDirectorate(boolean active, Long idDir);

    long countByActiveAndDepartment(boolean active, Long idDep);

    long countByActiveAndSubdepartment(boolean active, Long idSubdep);
}
