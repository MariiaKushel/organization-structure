package com.mariiakushel.task.repository;

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
class DirectorateRepositoryTest {
    @Autowired
    private DirectorateRepository repository;

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

    public static Object[][] findByEntityIdAndActiveDataProvider() {
        Directorate dir = new Directorate();
        dir.setId(2L);
        dir.setName("Varna");
        dir.setDescription("Varna directorate description");
        dir.setActive(true);
        return new Object[][]{
                {2L, true, Optional.of(dir)},
                {1000000L, true, Optional.empty()},
                {2L, false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByEntityIdAndActiveDataProvider")
    void findByEntityIdAndActive(Long id, boolean active, Optional<Directorate> expected) {
        Optional<Directorate> actual = repository.findByIdAndActive(id, active);
        Assertions.assertEquals(expected, actual);
    }

    public static Object[][] findByNameAndActiveDataProvider() {
        Directorate dir = new Directorate();
        dir.setId(2L);
        dir.setName("Varna");
        dir.setDescription("Varna directorate description");
        dir.setActive(true);
        return new Object[][]{
                {"Varna", true, Optional.of(dir)},
                {"azaza", true, Optional.empty()},
                {"Varna", false, Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByNameAndActiveDataProvider")
    void findByNameAndActive(String name, boolean active, Optional<Directorate> expected) {
        Optional<Directorate> actual = repository.findByNameAndActive(name, active);
        Assertions.assertEquals(expected, actual);
    }
}