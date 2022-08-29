package com.mariiakushel.task.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void findAllByActive() {
    }

    @Test
    void findByIdAndActive() {
    }

    @Test
    void countByActiveAndDirectorate() {
        long expected = 0L;
        long actual = repository.countByActiveAndDirectorate(true, 2L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countByActiveAndDepartment() {
    }
}