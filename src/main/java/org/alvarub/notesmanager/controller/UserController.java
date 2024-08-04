package org.alvarub.notesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.alvarub.notesmanager.dto.UserDTO;
import org.alvarub.notesmanager.model.User;
import org.alvarub.notesmanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Guardar un nuevo usuario")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado", content = {
                    @Content(mediaType = "application/json",
                            schema =  @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content)
    })
    @PostMapping("/users/new")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("Usuario registrado", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar un usuario a través de su ID")
    @GetMapping("/users/find/{id}")
    @ResponseBody
    public UserDTO findUser(@PathVariable int id) {
        return userService.findUser(id);
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping("/users/find-all")
    @ResponseBody
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @Operation(summary = "Eliminar un usuario")
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "Usuario eliminado con éxito.";
    }

    @Operation(summary = "Actualizar un usuario")
    @PutMapping("/users/edit")
    public String editUser(@RequestBody User user) {
        userService.editUser(user);
        return "Los datos del usuario se han actualizado.";
    }
}
