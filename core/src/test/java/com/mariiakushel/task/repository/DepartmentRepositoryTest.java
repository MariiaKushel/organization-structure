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

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("dev")
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository repository;

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
        List<Department> departments = repository.findAllByDirectorateAndActive(dir, active, paging).toList();
        int actual = departments.size();
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findByIdAndDirectorateAndAndActiveDataProvider() {
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("Retail sales");
        dep.setDescription("Retail sales department");
        dep.setActive(true);
        Directorate dir = new Directorate();
        dir.setId(2L);
        return new Object[][]{
                {1L, dir, true, Optional.of(dep)},
                {1000000L, dir, true, Optional.empty()},
                {1L, dir, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByIdAndDirectorateAndAndActiveDataProvider")
    void findByIdAndDirectorateAndAndActive(Long id, Directorate dir, boolean active, Optional<Department> expected) {
        Optional<Department> actual = repository.findByIdAndDirectorateAndActive(id, dir, active);
        Assertions.assertEquals(expected, actual);
    }


    public static Object[][] findByNameAndDirectorateAndActiveDataProvider() {
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("Retail sales");
        dep.setDescription("Retail sales department");
        dep.setActive(true);
        Directorate dir = new Directorate();
        dir.setId(2L);
        return new Object[][]{
                {"Retail sales", dir, true, Optional.of(dep)},
                {"azaza", dir, true, Optional.empty()},
                {"Retail sales", dir, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByNameAndDirectorateAndActiveDataProvider")
    void findByNameAndDirectorateAndActive(String name, Directorate dir, boolean active, Optional<Department> expected) {
        Optional<Department> actual = repository.findByNameAndDirectorateAndActive(name, dir, active);
        Assertions.assertEquals(expected, actual);
    }
}