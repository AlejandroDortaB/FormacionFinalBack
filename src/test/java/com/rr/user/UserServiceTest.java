package com.rr.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.rr.reservation.ReservationRepository;
import com.rr.restaurant.RestaurantRepository;
import com.rr.role.Role;
import com.rr.role.RoleRepository;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

       @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Captor
    ArgumentCaptor<User> argCaptor;

    @InjectMocks
    UserService undertest;

    @BeforeEach
    void setUp() {
        undertest = new UserService(userRepository, reservationRepository, roleRepository, restaurantRepository);
    }

    
    @Test
    void testGetUserConversations() {

    }

    @Test
    void testGetUserReservation() {

    }

    @Test
    void testGetUserRestaurants() {

    }

   @DisplayName("Debe poder modificar el rol del usuario")
    @Test
    void testModifyUserRole() {
        // given
        int userId = 1; // ID del usuario
        int roleId = 2; // ID del nuevo rol

        Role initialRole = new Role(1, "Cliente");
        Role newRole = new Role(2, "Admin");

        Optional<User> userParameter = Optional.of(new User("userName", "password", initialRole));
        Optional<Role> roleParameter = Optional.of(newRole);

        // Configurar mocks para devolver valores esperados
        given(this.userRepository.findById(userId)).willReturn(userParameter);
        given(this.roleRepository.findById(roleId)).willReturn(roleParameter);

        // Verificaciones intermedias
        assertTrue(this.userRepository.findById(userId).isPresent(), "Mock de userRepository debe devolver un usuario");
        assertTrue(this.roleRepository.findById(roleId).isPresent(), "Mock de roleRepository debe devolver un rol");

        // when
        this.undertest.modifyUserRole(userId, roleId);

        // then
        verify(this.userRepository).save(argCaptor.capture());
        assertEquals(argCaptor.getValue().getRole(), newRole);
    }
}
