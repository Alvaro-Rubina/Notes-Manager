package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.model.dto.NewUserDTO;
import org.alvarub.notesmanager.model.dto.UserDTO;

import java.util.List;

public interface IUserService {

    public void saveUser(NewUserDTO newUserDTO);
    public UserDTO findUser(int id);
    public List<UserDTO> getUsers();
    public void deleteUser(int id);
    public void editUser(int idUser, NewUserDTO newUserDTO);
}
