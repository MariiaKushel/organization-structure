package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.Department;
import com.mariiakushel.task.repository.entity.Directorate;
import org.junit.jupiter.api.Assertions;
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
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository repository;

    public static Object[][] findByIdAndActiveDataProvider() {
        Department dep = new Department();
        dep.setId(2L);
        dep.setName("Sales");
        dep.setDescription("Sales department description");
        dep.setActive(true);
        return new Object[][]{
                {2L, true, Optional.of(dep)},
                {1000L, true, Optional.empty()},
                {2L, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByIdAndActiveDataProvider")
    void findByIdAndActive(Long id, boolean active, Optional<Department> expected) {
        Optional<Department> actual = repository.findByIdAndActive(id, active);
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findByNameAndDirectorateAndActiveDataProvider() {
        Department dep = new Department();
        dep.setId(2L);
        dep.setName("Sales");
        dep.setDescription("Sales department description");
        dep.setActive(true);
        Directorate dir = new Directorate();
        dir.setId(1L);
        return new Object[][]{
                {"Sales", dir, true, Optional.of(dep)},
                {"azaza", dir, true, Optional.empty()},
                {"Sales", dir, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByNameAndDirectorateAndActiveDataProvider")
    void findByNameAndDirectorateAndActive(String name, Directorate dir, boolean active, Optional<Department> expected) {
        Optional<Department> actual = repository.findByNameAndDirectorateAndActive(name, dir, active);
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

    public static Object[][] findAllByDirectorateAndActiveDataProvider() {
        Pageable paging1 = PageRequest.of(0, 3);
        Pageable paging2 = PageRequest.of(100, 3);
        Directorate dir = new Directorate();
        dir.setId(3L);
        return new Object[][]{
                {dir, true, paging1, 3},
                {dir, true, paging2, 0},
                {dir, false, paging1, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("findAllByDirectorateAndActiveDataProvider")
    void findAllByDirectorateAndActive(Directorate dir, boolean active, Pageable paging, int expected) {
        int actual = repository.findAllByDirectorateAndActive(dir, active, paging).toList().size();
        Assertions.assertEquals(expected, actual);
    }

}