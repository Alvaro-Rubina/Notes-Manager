package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.model.User;

import java.util.List;

public interface IUserService {

    public void saveUser(User user);
    public User findUser(int id);
    public List<User> getUsers();
    public void deleteUser(int id);
    public void editUser(User user);
}
