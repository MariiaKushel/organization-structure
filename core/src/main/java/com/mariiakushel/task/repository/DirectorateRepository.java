package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Directorate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DirectorateRepository extends PagingAndSortingRepository<Directorate, Long> {

    Page<Directorate> findAllByActive (boolean active, Pageable pageable);

    Optional<Directorate> findByIdAndActive (Long id, boolean active);

    Optional<Directorate> findByNameAndActive (String name, boolean active);
}
