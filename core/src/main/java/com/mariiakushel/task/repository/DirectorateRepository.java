package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Directorate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Interface for database operation with Directorate entity
 */
public interface DirectorateRepository extends PagingAndSortingRepository<Directorate, Long> {

    /**
     * Method gets Directorate by id and active.
     *
     * @param id     Directorate id
     * @param active active status
     * @return Optional representation of Directorate or empty Optional, if Directorate was not found
     */
    Optional<Directorate> findByIdAndActive(Long id, boolean active);

    /**
     * Method gets Directorate by personal id and active.
     *
     * @param name   Directorate name
     * @param active active status
     * @return Optional representation of Directorate or empty Optional, if Directorate was not found
     */
    Optional<Directorate> findByNameAndActive(String name, boolean active);

    /**
     * Method gets all Directorates by active in current range of pages.
     *
     * @param active active status
     * @param paging pagination parameters
     * @return Page of Directorate or empty Page if no one Directorate was found
     */
    Page<Directorate> findAllByActive(boolean active, Pageable paging);
}
