package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.mapper.NoteMapper;
import org.alvarub.notesmanager.exception.NoteNotFoundException;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    NoteDAO noteDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    NoteMapper noteMapper;

    @Override
    public void saveNote(Note note) {
        if (note.getTitle() == null || note.getTitle().isEmpty()){
            throw new IllegalArgumentException("El título de la nota es obligatorio");

        } else if (note.getContent() == null || note.getContent().isEmpty()){
            throw new IllegalArgumentException("El contenido de la nota es obligatorio");

        } else if (note.getUser() == null){
            throw new IllegalArgumentException("El usuario no puede ser nulo");

        } else if (!userDAO.existsById(Math.toIntExact(note.getUser().getUserID()))){
            throw new UserNotFoundException("No existe el usuario con el id: " + note.getUser().getUserID());

        } else {
            noteDAO.save(note);
        }
    }

    @Override
    public NoteDTO findNote(int id) {

        Note note;
        if (noteDAO.findById(id).isPresent()){
            note = noteDAO.findById(id).get();
        } else {
            throw new NoteNotFoundException("No existe la nota con el id: " + id);
        }

        NoteDTO noteDTO = noteMapper.noteToNoteDTO(note);
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getNotes() {

        List<Note> notes = noteDAO.findAll();
        List<NoteDTO> noteDTOs = noteMapper.noteListToNoteDTOList(notes);
        return noteDTOs;
    }

    @Override
    public void deleteNote(int id) {

        if (noteDAO.findById(id).isPresent()) {
            noteDAO.deleteById(id);
        } else {
            throw new NoteNotFoundException("No existe la nota con el id: " + id);
        }
    }

    @Override
    public void editNote(Note note) {

        if (note.getNoteID() == null){
            throw new IllegalArgumentException("El ID de la nota a editar es obligatorio");
        }

        Note existingNote = noteDAO.findById(Math.toIntExact(note.getNoteID())).orElseThrow(() ->
                new NoteNotFoundException("No existe la nota con el id: " + note.getNoteID()));

        if (note.getTitle() != null) {
            existingNote.setTitle(note.getTitle());
        }
        if (note.getContent() != null) {
            existingNote.setContent(note.getContent());
        }
        if (note.getUser() != null) {
            if (!userDAO.existsById(Math.toIntExact(note.getUser().getUserID()))) {
                throw new UserNotFoundException("No existe el usuario con el id: " + note.getUser().getUserID());
            }
            existingNote.setUser(note.getUser());
        }

        noteDAO.save(existingNote);
    }
}
