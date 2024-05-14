package org.alvarub.rtnotes.controller;

import org.alvarub.rtnotes.model.Note;
import org.alvarub.rtnotes.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private INoteService noteService;

    @PostMapping("/notes/new")
    public String saveNote(@RequestBody Note note) {
        noteService.saveNote(note);
        return "Nota añadida!";
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
