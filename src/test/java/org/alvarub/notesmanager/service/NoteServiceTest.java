/*
package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.NewNoteDTO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.exception.NoteNotFoundException;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.mapper.NoteMapper;
import org.alvarub.notesmanager.model.entity.Note;

import org.alvarub.notesmanager.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceTest {

    @Mock
    NoteDAO noteDAO;
    @Mock
    UserDAO userDAO;

    @Mock
    NoteMapper noteMapper;

    @InjectMocks
    NoteService noteService;

    // Attributes
    private Note note1;
    private Note note2;

    private NewNoteDTO newNote1;
    private NewNoteDTO newNote2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveNote() {
        newNote1 = new NewNoteDTO("A silly note", "Blablabla", 1L);
        note1 = new Note();

        when(userDAO.existsById(1)).thenReturn(true);
        when(noteMapper.newNoteDTOToNote(newNote1)).thenReturn(note1);
        when(userDAO.findById(1)).thenReturn(Optional.of(new User()));

        noteService.saveNote(newNote1);
        verify(userDAO, times(1)).existsById(1);
        verify(noteDAO, times(1)).save(note1);
    }

    @Test
    @DisplayName("saveNote() - Empty or null fields")
    void saveNoteEmptyFields() {
        // 4 casos de prueba (Sin título, sin contenido, sin usuario, y usuario no existente)
        newNote1 = new NewNoteDTO("", "Blablabla", 1L);
        newNote2 = new NewNoteDTO("A silly note", "", 1L);

        when(userDAO.existsById(1)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(newNote1));
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(newNote2));

        newNote1 = new NewNoteDTO("A silly note", "Blablabla", null);
        newNote2 = new NewNoteDTO("A silly note", "Blablabla", 1L);

        when(userDAO.existsById(1)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(newNote1));
        assertThrows(UserNotFoundException.class, () -> noteService.saveNote(newNote2));
    }

    @Test
    void findNote() {
        note1 = new Note();
        note1.setNoteID(1L);

        NoteDTO noteDTO = new NoteDTO();
        when(noteDAO.findById(1)).thenReturn(Optional.of(note1));
        when(noteMapper.noteToNoteDTO(note1)).thenReturn(noteDTO);

        NoteDTO noteResult = noteService.findNote(1);

        assertNotNull(noteResult);
        // En NoteService, se llama 2 veces al metodo finById: Una vez para verificar si la nota existe
        // y otra vez para obtener la nota
        verify(noteDAO, times(2)).findById(1);
        verify(noteMapper, times(1)).noteToNoteDTO(note1);

    }

    @Test
    @DisplayName("findNote() - Note not found")
    void findNoteNotFound(){
        when(noteDAO.findById(1)).thenReturn(Optional.empty());
        assertThrows(NoteNotFoundException.class, () -> noteService.findNote(1));
    }

    @Test
    void getNotes() {
        note1 = new Note();
        note2 = new Note();
        List<Note> notes = List.of(note1, note2);
        List<NoteDTO> noteDTOS = List.of(new NoteDTO(), new NoteDTO());

        when(noteDAO.findAll()).thenReturn(notes);
        when(noteMapper.noteListToNoteDTOList(notes)).thenReturn(noteDTOS);

        List<NoteDTO> notesResult = noteService.getNotes();

        assertNotNull(notesResult);
        assertEquals(2, notesResult.size());
        verify(noteDAO, times(1)).findAll();
        verify(noteMapper, times(1)).noteListToNoteDTOList(notes);
    }

    @Test
    void deleteNote() {
        note1 = new Note();
        when(noteDAO.findById(1)).thenReturn(Optional.of(note1));

        noteService.deleteNote(1);

        verify(noteDAO, times(1)).findById(1);
        verify(noteDAO, times(1)).deleteById(1);

    }

    @Test
    @DisplayName("deleteNote() - Note not found")
    void deleteNoteNotFound(){
        when(noteDAO.findById(1)).thenReturn(Optional.empty());
        assertThrows(NoteNotFoundException.class, () -> noteService.deleteNote(1));
    }

    @Test
    void editNote() {
        newNote1 = new NewNoteDTO("A NEW (!!!) silly note", "Blablabla (v2)", 1L);
        note1 = new Note("A silly note", "Blablabla", new User());

        when(noteDAO.findById(1)).thenReturn(Optional.of(note1));
        when(userDAO.existsById(1)).thenReturn(true);
        when(userDAO.findById(1)).thenReturn(Optional.of(new User()));

        noteService.editNote(1, newNote1);

        verify(noteDAO, times(2)).findById(1);
        verify(userDAO, times(1)).existsById(1);
        verify(noteDAO, times(1)).save(note1);
    }

    @Test
    @DisplayName("editNote() - User not found")
    void editNoteWithUserNotFound() {
        newNote1 = new NewNoteDTO("A NEW (!!!) silly note", "Blablabla (v2)", 1L);
        note1 = new Note("A silly note", "Blablabla", new User());

        when(noteDAO.findById(1)).thenReturn(Optional.of(note1));
        when(userDAO.existsById(1)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> noteService.editNote(1, newNote1));
    }

    @Test
    @DisplayName("editNote() - Note not found")
    void editNoteNotFound() {
        newNote1 = new NewNoteDTO("A NEW (!!!) silly note", "Blablabla (v2)", 1L);
        note1 = new Note("A silly note", "Blablabla", new User());

        when(noteDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(NoteNotFoundException.class, () -> noteService.editNote(1, newNote1));
    }
}
*/
