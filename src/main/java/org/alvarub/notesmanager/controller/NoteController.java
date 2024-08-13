package org.alvarub.notesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.alvarub.notesmanager.model.dto.NewNoteDTO;
import org.alvarub.notesmanager.model.dto.NoteDTO;
import org.alvarub.notesmanager.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Notas", description = "Controller | Consultas y operaciones con notas")
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @Operation(summary = "Guardar una nueva nota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota creada", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewNoteDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
    })
    @PostMapping
    public ResponseEntity<String> saveNote(@RequestBody @Valid NewNoteDTO newNoteDTO) {
        noteService.saveNote(newNoteDTO);
        return new ResponseEntity<>("Nota creada", HttpStatus.CREATED);
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
    @GetMapping("/{id}") @ResponseBody
    public ResponseEntity<?> findNote(@Parameter(description = "ID de la nota", example = "1") @PathVariable int id) {
        return new ResponseEntity<>(noteService.findNote(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todas las notas")

    @GetMapping @ResponseBody
    public List<NoteDTO> getAllNotes() {
        return noteService.getNotes();
    }

    @Operation(summary = "Eliminar una nota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota eliminada", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nota no encontrada", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@Parameter(description = "ID de la nota", example = "1") @PathVariable int id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>("Nota eliminada", HttpStatus.OK);
    }

    @Operation(summary = "Actualizar una nota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota actualizada", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewNoteDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nota o usuario no encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNote(@PathVariable int id ,@Valid @RequestBody NewNoteDTO newNoteDTO) {
        noteService.editNote(id, newNoteDTO);
        return new ResponseEntity<>("Nota actualizada", HttpStatus.OK);
    }
}
