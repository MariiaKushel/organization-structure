package com.mariiakushel.task.repository;

import com.mariiakushel.task.enumeration.Position;
import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.Subdepartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;

    public static Object[][] findByIdAndActiveDataProvider() {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Yanko");
        emp.setSurname("Yovkov");
        emp.setPersonalId("100000001");
        emp.setAge(55);
        emp.setActive(true);
        emp.setPosition(Position.DIRECTOR_OF_DIRECTORATE);
        return new Object[][]{
                {1L, true, Optional.of(emp)},
                {1L, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByIdAndActiveDataProvider")
    void findByIdAndActive(Long id, boolean active, Optional<Employee> expected) {
        Optional<Employee> actual = repository.findByIdAndActive(id, active);
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findByPersonalIdAndActiveDataProvider() {
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Yanko");
        emp.setSurname("Yovkov");
        emp.setPersonalId("100000001");
        emp.setAge(55);
        emp.setActive(true);
        emp.setPosition(Position.DIRECTOR_OF_DIRECTORATE);
        return new Object[][]{
                {"100000001", true, Optional.of(emp)},
                {"100000001", false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByPersonalIdAndActiveDataProvider")
    void findByPersonalIdAndActive(String personalId, boolean active, Optional<Employee> expected) {
        Optional<Employee> actual = repository.findByPersonalIdAndActive(personalId, active);
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findAllByActiveDataProvider() {
        Pageable paging1 = PageRequest.of(0, 3);
        Pageable paging2 = PageRequest.of(100, 3);
        return new Object[][]{
                {true, paging1, 3},
                {true, paging2, 0},
                {false, paging1, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("findAllByActiveDataProvider")
    void findAllByActive(boolean active, Pageable paging, int expected) {
        int actual = repository.findAllByActive(active, paging).toList().size();
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findAllByActiveAndDepartmentDataProvider() {
        Pageable paging1 = PageRequest.of(0, 3);
        Pageable paging2 = PageRequest.of(100, 3);
        Department dep = new Department(2L);
        return new Object[][]{
                {true, dep, paging1, 3},
                {true, dep, paging2, 0},
                {false, dep, paging1, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("findAllByActiveAndDepartmentDataProvider")
    void findAllByActiveAndDepartment(boolean active, Department dep, Pageable paging, int expected) {
        int actual = repository.findAllByActiveAndSubdepartmentDepartment(active, dep, paging).size();
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findAllByActiveAndDirectorateDataProvider() {
        Pageable paging1 = PageRequest.of(0, 3);
        Pageable paging2 = PageRequest.of(100, 3);
        Directorate dir = new Directorate(1L);
        return new Object[][]{
                {true, dir, paging1, 3},
                {true, dir, paging2, 0},
                {false, dir, paging1, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("findAllByActiveAndDirectorateDataProvider")
    void findAllByActiveAndDirectorate(boolean active, Directorate dir, Pageable paging, int expected) {
        int actual = repository.findAllByActiveAndSubdepartmentDepartmentDirectorate(active, dir, paging).size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countByActiveAndDirectorate() {
        long expected = 56L;
        long actual = repository.countByActiveAndSubdepartmentDepartmentDirectorate(true, new Directorate(1L));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countByActiveAndDepartment() {
        long expected = 11L;
        long actual = repository.countByActiveAndSubdepartmentDepartment(true, new Department(2L));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countByActiveAndSubdepartment() {
        long expected = 10L;
        long actual = repository.countByActiveAndSubdepartment(true, new Subdepartment(3L));
        Assertions.assertEquals(expected, actual);
    }
}