package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.model.dto.NewUserDTO;
import org.alvarub.notesmanager.model.dto.UserDTO;
import org.alvarub.notesmanager.utils.exception.UserNotFoundException;
import org.alvarub.notesmanager.utils.mapper.UserMapper;
import org.alvarub.notesmanager.model.entity.User;
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
    public void saveUser(NewUserDTO newUserDTO) {
        if(newUserDTO.userName() == null || newUserDTO.userName().isEmpty()){
            throw new IllegalArgumentException("El username es obligatorio");

        } else if (newUserDTO.name() == null || newUserDTO.name().isEmpty()){
            throw new IllegalArgumentException("El nombre es obligatorio");

        } else if (newUserDTO.lastName() == null || newUserDTO.lastName().isEmpty()){
            throw new IllegalArgumentException("El apellido es obligatorio");

        } else {
            User user = userMapper.newUserDTOToUser(newUserDTO);
            userDAO.save(user);
        }
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
        List<UserDTO> userDTOs= userMapper.userListToUserDTOList(users);
        return userDTOs;
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
    public void editUser(int id, NewUserDTO newUserDTO) {

        User user;
        if (userDAO.findById(id).isPresent()){
            user = userDAO.findById(id).get();

        } else {
            throw new UserNotFoundException("No existe el usuario con el id: " + id);
        }

        if (newUserDTO.userName() != null){
            user.setUserName(newUserDTO.userName());
        }
        if (newUserDTO.name() != null){
            user.setName(newUserDTO.name());
        }
        if (newUserDTO.lastName() != null){
            user.setLastName(newUserDTO.lastName());
        }

        userDAO.save(user);
    }
}
