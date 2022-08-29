package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Page<Employee> findAllByActive(boolean active, Pageable paging);

    Optional<Employee> findByIdAndActive(Long id, boolean active);
}
