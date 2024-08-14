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
        User user = userMapper.newUserDTOToUser(newUserDTO);
        userDAO.save(user);
    }

    @Override
    public UserDTO findUser(int id) {
        User user = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " does not exist"));
        return userMapper.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userDAO.findAll();
        return userMapper.userListToUserDTOList(users);
    }

    @Override
    public void deleteUser(int id) {
        User user = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " does not exist"));
        userDAO.delete(user);
    }

    @Override
    public void editUser(int id, NewUserDTO newUserDTO) {
        User user = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " does not exist"));

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
