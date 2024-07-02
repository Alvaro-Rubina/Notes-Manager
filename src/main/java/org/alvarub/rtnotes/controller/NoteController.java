package org.alvarub.rtnotes.controller;

import org.alvarub.rtnotes.exception.UserNotFoundException;
import org.alvarub.rtnotes.model.Note;
import org.alvarub.rtnotes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private INoteService noteService;

    @PostMapping("/notes/new")
    public ResponseEntity<String> saveNote(@RequestBody Note note) {
        try {
            noteService.saveNote(note);
            return new ResponseEntity<>("Nota añadida!", HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/notes/find/{id}")
    @ResponseBody
    public Note findNote(@PathVariable int id) {
        return noteService.findNote(id);
    }

    @GetMapping("/notes/find-all")
    @ResponseBody
    public List<Note> findAllNotes() {
        return noteService.getNotes();
    }

    @DeleteMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return "Nota eliminada con éxito";
    }

    @PutMapping("/notes/edit")
    public String updateNote(@RequestBody Note note) {
        noteService.editNote(note);
        return "Nota actualizada!";
    }
}
