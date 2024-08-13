package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.model.dto.NewNoteDTO;
import org.alvarub.notesmanager.model.dto.NoteDTO;
import org.alvarub.notesmanager.utils.mapper.NoteMapper;
import org.alvarub.notesmanager.utils.exception.NoteNotFoundException;
import org.alvarub.notesmanager.model.entity.Note;
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
    public void saveNote(NewNoteDTO newNoteDTO) {
        Note note = noteMapper.newNoteDTOToNote(newNoteDTO);
        note.setUser(userDAO.findById(Math.toIntExact(newNoteDTO.creatorID())).orElseThrow(() -> new NoteNotFoundException("No existe el usuario con el id: " + newNoteDTO.creatorID())));
        noteDAO.save(note);
    }

    @Override
    public NoteDTO findNote(int id) {
        Note note = noteDAO.findById(id).orElseThrow(() -> new NoteNotFoundException("No existe la nota con el id: " + id));
        return noteMapper.noteToNoteDTO(note);
    }

    @Override
    public List<NoteDTO> getNotes() {
        List<Note> notes = noteDAO.findAll();
        return noteMapper.noteListToNoteDTOList(notes);
    }

    @Override
    public void deleteNote(int id) {
        Note note = noteDAO.findById(id).orElseThrow(() -> new NoteNotFoundException("No existe la nota con el id: " + id));
        noteDAO.delete(note);
    }

    @Override
    public void editNote(int idNote, NewNoteDTO newNoteDTO) {
        Note note = noteDAO.findById(idNote).orElseThrow(() -> new NoteNotFoundException("No existe la nota con el id: " + idNote));

        if (newNoteDTO.title() != null) {
            note.setTitle(newNoteDTO.title());
        }
        if (newNoteDTO.content() != null) {
            note.setContent(newNoteDTO.content());
        }
        if (newNoteDTO.creatorID() != null) {
            note.setUser(userDAO.findById(Math.toIntExact(newNoteDTO.creatorID())).get());
        }
        noteDAO.save(note);
    }
}
