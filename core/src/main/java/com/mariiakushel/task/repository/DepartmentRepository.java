package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    Optional<Department> findByIdAndActive(Long id, boolean active);

    Optional<Department> findByIdAndDirectorateAndActive(Long id, Directorate dir, boolean active);

    Optional<Department> findByNameAndDirectorateAndActive(String name, Directorate dir, boolean active);

    Page<Department> findAllByActive(boolean active, Pageable paging);

    Page<Department> findAllByDirectorateAndActive(Directorate dir, boolean active, Pageable paging);


}
