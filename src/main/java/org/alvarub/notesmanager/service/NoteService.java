package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.NewNoteDTO;
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
    public void saveNote(NewNoteDTO newNoteDTO) {
        if (newNoteDTO.title() == null || newNoteDTO.title().isEmpty()){
            throw new IllegalArgumentException("El título de la nota es obligatorio");

        } else if (newNoteDTO.content() == null || newNoteDTO.content().isEmpty()){
            throw new IllegalArgumentException("El contenido de la nota es obligatorio");

        } else if (newNoteDTO.creatorID() == null){
            throw new IllegalArgumentException("El usuario no puede ser nulo");

        } else if (!userDAO.existsById(Math.toIntExact(newNoteDTO.creatorID()))){
            throw new UserNotFoundException("No existe el usuario con el id: " + newNoteDTO.creatorID());

        } else {
            Note note = noteMapper.newNoteDTOToNote(newNoteDTO);
            note.setUser(userDAO.findById(Math.toIntExact(newNoteDTO.creatorID())).get());
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
    public void editNote(int idNote, NewNoteDTO newNoteDTO) {

        Note note;
        if (noteDAO.findById(idNote).isPresent()){
            note = noteDAO.findById(idNote).get();
        } else {
            throw new NoteNotFoundException("No existe la nota con el id: " + idNote);
        }

        if (newNoteDTO.creatorID() != null && !userDAO.existsById(Math.toIntExact(newNoteDTO.creatorID()))){
            throw new UserNotFoundException("No existe el usuario con el id: " + newNoteDTO.creatorID());
        }

        if (newNoteDTO.title() != null){
            note.setTitle(newNoteDTO.title());
        }
        if (newNoteDTO.content() != null) {
            note.setContent(newNoteDTO.content());
        }
        if (newNoteDTO.creatorID() != null){
            note.setUser(userDAO.findById(Math.toIntExact(newNoteDTO.creatorID())).get());
        }
        noteDAO.save(note);
    }
}
