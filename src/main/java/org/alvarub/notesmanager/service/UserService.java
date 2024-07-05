package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.mapper.UserMapper;
import org.alvarub.notesmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserMapper userMapper;

    @Override
    public void saveUser(User user) {

        if (user.getUserName().isEmpty() || user.getUserName().isEmpty() || user.getLastName().isEmpty()){
            throw new IllegalArgumentException("El usuario debe tener nombre de usuario, nombre y apellido");
        }

        userDAO.save(user);
    }

    @Override
    public UserDTO findUser(int id) {

        User user;
        if (userDAO.findById(id).isPresent()){
            user = userDAO.findById(id).get();
        } else {
            throw new UserNotFoundException("No existe el usuario con el id: " + id);
        }

        UserDTO userDTO = userMapper.userToUserDTO(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsers() {

        List<User> users = userDAO.findAll();

        if (users.isEmpty()) {
            throw new IllegalArgumentException("No hay usuarios en la base de datos");
        } else {
            List<UserDTO> userDTOS = userMapper.userListToUserDTOList(users);
            return userDTOS;
        }
    }

    @Override
    public void deleteUser(int id) {

        if (userDAO.findById(id).isPresent()){
            userDAO.deleteById(id);
        } else {
            throw new UserNotFoundException("No existe el usuario con el id: " + id);
        }
    }

    @Override
    public void editUser(User user) {
        this.saveUser(user);
    }
}
