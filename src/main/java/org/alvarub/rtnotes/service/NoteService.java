package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dao.NoteDAO;
import org.alvarub.rtnotes.exception.UserNotFoundException;
import org.alvarub.rtnotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    NoteDAO noteDAO;

    @Override
    public void saveNote(Note note) {
        if (note.getUser() == null){
            throw new UserNotFoundException("El usuario de la nota no puede ser nulo");
        }

        if (!this.checkNoteLength(note)){
            throw new IllegalArgumentException("La nota no puede tener más de 1000 carácteres");
        }

        note.setDate(LocalDate.now());
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

    // Se agrega un límite de caracteres a las notas, 1000 como ejemplo en este caso y por ahora.
    public boolean checkNoteLength(Note note){
        return note.getContent().length() <= 1000;
    }
}
