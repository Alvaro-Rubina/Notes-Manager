package org.alvarub.notesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.exception.NoteNotFoundException;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.model.Note;
import org.alvarub.notesmanager.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private INoteService noteService;

    @Operation(summary = "Guardar una nueva nota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota creada", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @PostMapping("/notes/new")
    public ResponseEntity<String> saveNote(@RequestBody Note note) {
        try {
            noteService.saveNote(note);
            return new ResponseEntity<>("Nota creada", HttpStatus.CREATED);

        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Buscar una nota a través de su ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Nota encontrada",
                content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = NoteDTO.class))
                }),
            @ApiResponse(responseCode = "404", description = "Nota no encontrada", content = @Content)
    })
    @GetMapping("/notes/find/{id}")
    @ResponseBody
    public ResponseEntity<?> findNote(@Parameter(description = "ID de la nota", example = "1") @PathVariable int id) {
        try {
            return new ResponseEntity<>(noteService.findNote(id), HttpStatus.OK);

        } catch (NoteNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Obtener todas las notas")

    @GetMapping("/notes/find-all")
    @ResponseBody
    public List<NoteDTO> getAllNotes() {
        return noteService.getNotes();
    }

    @Operation(summary = "Eliminar una nota")
    @DeleteMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return "Nota eliminada con éxito";
    }

    @Operation(summary = "Actualizar una nota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota actualizada", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nota o usuario no encontrado", content = @Content)
    })
    @PutMapping("/notes/edit")
    public ResponseEntity<String> updateNote(@RequestBody Note note) {

        try {
            noteService.editNote(note);
            return new ResponseEntity<>("Nota actualizada", HttpStatus.CREATED);

        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (NoteNotFoundException | UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
