package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dto.UserDTO;
import org.alvarub.rtnotes.model.User;

import java.util.List;

public interface IUserService {

    public void saveUser(User user);
    public UserDTO findUser(int id);
    public List<UserDTO> getUsers();
    public void deleteUser(int id);
    public void editUser(User user);
}
