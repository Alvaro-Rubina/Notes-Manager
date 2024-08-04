package org.alvarub.notesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.alvarub.notesmanager.dto.NoteDTO;
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
    @PostMapping("/notes/new")
    public ResponseEntity<String> saveNote(@RequestBody Note note) {
        try {
            noteService.saveNote(note);
            return new ResponseEntity<>("Nota añadida!", HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar una nota a través de su ID")
    @GetMapping("/notes/find/{id}")
    @ResponseBody
    public NoteDTO findNote(@PathVariable int id) {
        return noteService.findNote(id);
    }

    @Operation(summary = "Obtener todas las notas")
    @GetMapping("/notes/find-all")
    @ResponseBody
    public List<NoteDTO> findAllNotes() {
        return noteService.getNotes();
    }

    @Operation(summary = "Eliminar una nota")
    @DeleteMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return "Nota eliminada con éxito";
    }

    @Operation(summary = "Actualizar una nota")
    @PutMapping("/notes/edit")
    public String updateNote(@RequestBody Note note) {
        noteService.editNote(note);
        return "Nota actualizada!";
    }
}
