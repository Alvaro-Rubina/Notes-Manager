package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dao.UserDAO;
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
        userDAO.save(user);
    }

    @Override
    public User findUser(int id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public void editUser(User user) {
        this.saveUser(user);
    }
}
