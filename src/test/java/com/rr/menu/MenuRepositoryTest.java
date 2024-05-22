package com.rr.menu;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rr.user.User;
import com.rr.user.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class MenuRepositoryTest {
     @Autowired
    private UserRepository underTest;

    @DisplayName("Debe poder encontrar el usuario por su nombre de usuario")
    @Test
    void ItShouldFindUserByUsername() {
        //given
        User user = new User();
        String username = "username";
        user.setUsername(username);

        underTest.save(user);
        //when
       User result = this.underTest.findByUsername(username);
        //then
        assertThat(result).isEqualTo(user);
    }
}
