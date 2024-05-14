package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dao.NoteDAO;
import org.alvarub.rtnotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    NoteDAO noteDAO;

    @Override
    public void saveNote(Note note) {
        noteDAO.save(note);
    }

    @Override
    public Note findNote(int id) {
        return noteDAO.findById(id).orElse(null);
    }

    @Override
    public List<Note> getNotes() {
        return noteDAO.findAll();
    }

    @Override
    public void deleteNote(int id) {
        noteDAO.deleteById(id);
    }

    @Override
    public void editNote(Note note) {
        this.saveNote(note);
    }
}
