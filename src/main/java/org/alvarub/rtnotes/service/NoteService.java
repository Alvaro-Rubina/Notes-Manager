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

        note.setCreationDate(LocalDate.now());
        noteDAO.save(note);
    }

    @Override
    public Note findNote(int id) {
        // TODO: Devolver un DTO en lugar de la entidad. Hacer uso de MapStruct.
        // TODO: Agregar validaciones
        return noteDAO.findById(id).orElse(null);

    }

    @Override
    public List<Note> getNotes() {
        // TODO: Cambiar el retorno, en lugar de una lista de entidades, devolver una lista de DTOs.
        // TODO: Agregar validaciones
        return noteDAO.findAll();
    }

    @Override
    public void deleteNote(int id) {
        // TODO: Agregar validaciones
        noteDAO.deleteById(id);
    }

    @Override
    public void editNote(Note note) {
        // TODO: Agregar validaciones
        this.saveNote(note);
    }

    // Metodos privados
    public boolean checkNoteLength(Note note){
        return note.getContent().length() <= 1000;
    }
}
