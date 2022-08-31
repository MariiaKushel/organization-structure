package com.mariiakushel.task.repository;

import com.mariiakushel.task.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    public static Object[][] findByUsernameAndActiveDataProvider() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("{bcrypt}$2a$10$aKgYJnZjeYtg2EyseiXgPuoujnF.1eg0d8RIufsynUjFucA9RJ1eC");
        user.setId(1L);
        user.setActive(true);

        return new Object[][]{
                {"admin", Optional.of(user)},
                {"azaza", Optional.empty()}
        };
    }

    @ParameterizedTest
    @MethodSource("findByUsernameAndActiveDataProvider")
    void findByUsernameAndActive(String username, Optional<User> expected) {
        Optional<User> actual = repository.findByUsernameAndActive(username, true);
        Assertions.assertEquals(expected, actual);
    }
}