package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Page<Employee> findAllByActive(boolean active, Pageable paging);

    Optional<Employee> findByIdAndActive(Long id, boolean active);

    long countByActiveAndDirectorate(boolean active, Long idDir);

    long countByActiveAndDepartment(boolean active, Long idDep);
}
