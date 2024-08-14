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
@Tag(name = "Users", description = "Controller | User queries")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Save a user")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "User registered", content = {
                    @Content(mediaType = "application/json",
                            schema =  @Schema(implementation = NewUserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content)
    })
    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody NewUserDTO newUserDTO) {
        userService.saveUser(newUserDTO);
        return new ResponseEntity<>("User registered", HttpStatus.CREATED);
    }

    @Operation(summary = "Find a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = {
                    @Content(mediaType = "application/json",
                        schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/{id}") @ResponseBody
    public ResponseEntity<?> findUser(@Parameter(description = "User ID", example = "1") @PathVariable int id) {
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }

    @Operation(summary = "Get all users")
    @GetMapping @ResponseBody
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "User ID", example = "1") @PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @Operation(summary = "Update a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewUserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable int id ,@Valid @RequestBody NewUserDTO newUserDTO) {
        userService.editUser(id, newUserDTO);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
}
