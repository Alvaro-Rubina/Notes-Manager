package org.alvarub.rtnotes.controller;

import org.alvarub.rtnotes.dto.UserDTO;
import org.alvarub.rtnotes.model.User;
import org.alvarub.rtnotes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/users/new")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "Usuario registrado!";
    }

    @GetMapping("/users/find/{id}")
    @ResponseBody
    public UserDTO findUser(@PathVariable int id) {
        return userService.findUser(id);
    }

    @GetMapping("/users/find-all")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "Usuario eliminado con éxito.";
    }

    @PutMapping("/users/edit")
    public String editUser(@RequestBody User user) {
        userService.editUser(user);
        return "Los datos del usuario se han actualizado.";
    }
}
