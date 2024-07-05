package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.model.User;

import java.util.List;

public interface IUserService {

    public void saveUser(User user);
    public UserDTO findUser(int id);
    public List<UserDTO> getUsers();
    public void deleteUser(int id);
    public void editUser(User user);
}
