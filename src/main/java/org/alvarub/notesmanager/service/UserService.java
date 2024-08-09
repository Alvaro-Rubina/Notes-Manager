package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.NewUserDTO;
import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.exception.NoteNotFoundException;
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
    public void saveUser(NewUserDTO newUserDTO) {
        if(newUserDTO.getUserName() == null || newUserDTO.getUserName().isEmpty()){
            throw new IllegalArgumentException("El username es obligatorio");

        } else if (newUserDTO.getName() == null || newUserDTO.getName().isEmpty()){
            throw new IllegalArgumentException("El nombre es obligatorio");

        } else if (newUserDTO.getLastName() == null || newUserDTO.getLastName().isEmpty()){
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

        if (newUserDTO.getUserName() != null){
            user.setUserName(newUserDTO.getUserName());
        }
        if (newUserDTO.getName() != null){
            user.setName(newUserDTO.getName());
        }
        if (newUserDTO.getLastName() != null){
            user.setLastName(newUserDTO.getLastName());
        }

        userDAO.save(user);
    }
}
