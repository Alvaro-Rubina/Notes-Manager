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
@Tag(name = "Notes", description = "Controller | Note Queries")
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @Operation(summary = "Save a note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Note created", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewNoteDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<String> saveNote(@RequestBody @Valid NewNoteDTO newNoteDTO) {
        noteService.saveNote(newNoteDTO);
        return new ResponseEntity<>("Note created", HttpStatus.CREATED);
    }

    @Operation(summary = "Find a note by ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Note found",
                content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = NoteDTO.class))
                }),
            @ApiResponse(responseCode = "404", description = "Note not found", content = @Content)
    })
    @GetMapping("/{id}") @ResponseBody
    public ResponseEntity<?> findNote(@Parameter(description = "Note ID", example = "1") @PathVariable int id) {
        return new ResponseEntity<>(noteService.findNote(id), HttpStatus.OK);
    }

    @Operation(summary = "Get all notes")
    @GetMapping @ResponseBody
    public List<NoteDTO> getAllNotes() {
        return noteService.getNotes();
    }

    @Operation(summary = "Delete a note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Note deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Note not found", content = @Content)
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@Parameter(description = "Note ID", example = "1") @PathVariable int id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>("Note deleted", HttpStatus.OK);
    }

    @Operation(summary = "Update a note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Note updated", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NewNoteDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content),
            @ApiResponse(responseCode = "404", description = "Note or user not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNote(@PathVariable int id ,@Valid @RequestBody NewNoteDTO newNoteDTO) {
        noteService.editNote(id, newNoteDTO);
        return new ResponseEntity<>("Note updated", HttpStatus.OK);
    }
}
