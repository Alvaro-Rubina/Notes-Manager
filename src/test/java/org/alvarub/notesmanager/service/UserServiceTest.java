package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.mapper.UserMapper;
import org.alvarub.notesmanager.model.Note;
import org.alvarub.notesmanager.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    UserDAO userDAO;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    // Attributes
    private User user1;
    private User user2;
    private User user3;
    private User existingUser1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        user1 = new User(1L, "pucciE" ,"Enrico", "Pucci", null);

        userService.saveUser(user1);
        verify(userDAO, times(1)).save(user1);
    }

    @Test
    @DisplayName("saveUser() - Empty fields")
    void saveUserEmptyFields() {
        // 3 casos de prueba (sin username, sin nombre y sin apellido)
        user1 = new User(1L, "" ,"Enrico", "Pucci", null);
        user2 = new User(1L, "pucciE" ,"", "Pucci", null);
        user3 = new User(1L, "pucciE" ,"Enrico", "", null);

        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user1));
        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user2));
        assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user3));
    }

    @Test
    void findUser() {
        user1 = new User(1L, "pucciE" ,"Enrico", "Pucci", null);
        UserDTO userDTO = new UserDTO();

        when(userDAO.findById(1)).thenReturn(Optional.of(user1));
        when(userMapper.userToUserDTO(user1)).thenReturn(userDTO);

        UserDTO userResult = userService.findUser(1);

        assertNotNull(userResult);

        // En UserService, se llama 2 veces al metodo finById: Una vez para verificar si el usuario existe
        // y otra vez para obtener al usuario
        verify(userDAO, times(2)).findById(1);
        verify(userMapper, times(1)).userToUserDTO(user1);
    }

    @Test
    @DisplayName("findUser() - User not found")
    void findUserNotFound(){
        when(userDAO.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.findUser(1));
    }

    @Test
    void getUsers() {
        user1 = new User();
        user2 = new User();
        List<User> users = List.of(user1, user2);
        List<UserDTO> userDTOS = List.of(new UserDTO(), new UserDTO());

        when(userDAO.findAll()).thenReturn(users);
        when(userMapper.userListToUserDTOList(users)).thenReturn(userDTOS);

        List<UserDTO> usersResult = userService.getUsers();

        assertNotNull(usersResult);
        assertEquals(2, usersResult.size());
        verify(userDAO, times(1)).findAll();
        verify(userMapper, times(1)).userListToUserDTOList(users);
    }

    @Test
    void deleteUser() {
        user1 = new User();
        when(userDAO.findById(1)).thenReturn(Optional.of(user1));

        userService.deleteUser(1);

        verify(userDAO, times(1)).findById(1);
        verify(userDAO, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("deleteUser() - User not found")
    void deleteUserNotFound() {
        when(userDAO.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(1));
    }

    @Test
    void editUser() {
        user1 = new User(1L, "madeInHeaven" ,"Enrico", "Pucci", null);
        existingUser1 = new User(1L, "pucciE" ,"Enrico", "Pucci", null);

        when(userDAO.findById(1)).thenReturn(Optional.of(existingUser1));

        userService.editUser(existingUser1);

        verify(userDAO, times(1)).findById(1);
        verify(userDAO, times(1)).save(existingUser1);
    }

    @Test
    @DisplayName("editUser() - User without ID")
    void editUserWithoutId() {
        user1 = new User(null, "madeInHeaven" ,"Enrico", "Pucci", null);
        assertThrows(IllegalArgumentException.class, () -> userService.editUser(user1));
    }

    @Test
    @DisplayName("editUser() - User not found")
    void editUserNotFound() {
        user1 = new User(1L, "madeInHeaven" ,"Enrico", "Pucci", null);
        when(userDAO.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.editUser(user1));
    }
}