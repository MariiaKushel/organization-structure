package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsernameAndActive(String username, boolean active);
}
