package org.alvarub.notesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.alvarub.notesmanager.model.dto.NewUserDTO;
import org.alvarub.notesmanager.model.dto.UserDTO;
import org.alvarub.notesmanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Usuarios", description = "Controller | Consultas y operaciones con usuarios")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Guardar un nuevo usuario")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado", content = {
                    @Content(mediaType = "application/json",
                            schema =  @Schema(implementation = NewUserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody NewUserDTO newUserDTO) {
        userService.saveUser(newUserDTO);
        return new ResponseEntity<>("Usuario registrado", HttpStatus.CREATED);
    }

    @Operation(summary = "Buscar un usuario a través de su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado", content = {
                    @Content(mediaType = "application/json",
                        schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @GetMapping("/{id}") @ResponseBody
    public ResponseEntity<?> findUser(@Parameter(description = "ID del usuario", example = "1") @PathVariable int id) {
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping @ResponseBody
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @Operation(summary = "Eliminar un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "ID del usuario", example = "1") @PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
    }

    @Operation(summary = "Actualizar un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewUserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable int id ,@Valid @RequestBody NewUserDTO newUserDTO) {
        userService.editUser(id, newUserDTO);
        return new ResponseEntity<>("Usuario actualizado", HttpStatus.OK);
    }
}
