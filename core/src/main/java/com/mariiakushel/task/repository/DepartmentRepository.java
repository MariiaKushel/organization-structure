package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    Page<Department> findAllByActive(boolean active, Pageable paging);

    Optional<Department> findByIdAndActive(Long id, boolean active);
}
