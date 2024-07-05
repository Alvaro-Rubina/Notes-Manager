package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dao.UserDAO;
import org.alvarub.rtnotes.dto.UserDTO;
import org.alvarub.rtnotes.exception.UserNotFoundException;
import org.alvarub.rtnotes.mapper.UserMapper;
import org.alvarub.rtnotes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserDAO userDAO;

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
            throw new IllegalArgumentException("No existe el usuario con el id: " + id);
        }

        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsers() {

        List<User> users = userDAO.findAll();

        if (users.isEmpty()) {
            throw new IllegalArgumentException("No hay usuarios en la base de datos");
        } else {
            List<UserDTO> userDTOS = UserMapper.INSTANCE.userListToUserDTOList(users);
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
