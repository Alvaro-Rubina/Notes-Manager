package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
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
    NoteMapper noteMapper;

    @Override
    public void saveNote(Note note) {
        noteDAO.save(note);
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

        if (notes.isEmpty()){
            throw new NoteNotFoundException("No hay notas en la base de datos");
        } else {
            List<NoteDTO> noteDTOs = noteMapper.noteListToNoteDTOList(notes);
            return noteDTOs;
        }
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
        noteDAO.save(note);
    }
}
