package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.mapper.NoteMapper;
import org.alvarub.notesmanager.model.Note;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceTest {

    @Mock
    NoteDAO noteDAO;

    @Mock
    NoteMapper noteMapper;

    @InjectMocks
    NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveNote() {
        Note note = new Note();
        noteService.saveNote(note);
        verify(noteDAO, times(1)).save(note);
    }

    @Test
    void findNote() {
        Note note = new Note();
        note.setNoteID(1L);

        NoteDTO noteDTO = new NoteDTO();
        when(noteDAO.findById(1)).thenReturn(Optional.of(note));
        when(noteMapper.noteToNoteDTO(note)).thenReturn(noteDTO);

        NoteDTO noteResult = noteService.findNote(1);

        assertNotNull(noteResult);
        // En NoteService, se llama 2 veces al metodo finById: Una vez para verificar si la nota existe
        // y otra vez para obtener la nota
        verify(noteDAO, times(2)).findById(1);
        verify(noteMapper, times(1)).noteToNoteDTO(note);

    }

    @Test
    void getNotes() {
    }

    @Test
    void deleteNote() {
    }

    @Test
    void editNote() {
    }
}