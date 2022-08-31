package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interface for database operation with User entity
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Method gets User by username and active. Use for authentication.
     *
     * @param username User username
     * @param active   active status
     * @return Optional representation of User or empty Optional, if User was not found
     */
    Optional<User> findByUsernameAndActive(String username, boolean active);
}
