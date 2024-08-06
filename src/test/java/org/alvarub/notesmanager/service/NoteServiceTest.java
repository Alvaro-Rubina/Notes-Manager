package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.alvarub.notesmanager.dao.UserDAO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.exception.NoteNotFoundException;
import org.alvarub.notesmanager.exception.UserNotFoundException;
import org.alvarub.notesmanager.mapper.NoteMapper;
import org.alvarub.notesmanager.model.Note;

import org.alvarub.notesmanager.model.User;
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
    private Note existingNote1;
    private User user1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveNote() {
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("A silly note", "Blablabla", user1);

        when(userDAO.existsById(1)).thenReturn(true);

        noteService.saveNote(note1);
        verify(userDAO, times(1)).existsById(1);
        verify(noteDAO, times(1)).save(note1);
    }

    @Test
    void saveNoteEmptyFields() {
        // 4 casos de prueba (Sin título, sin contenido, sin usuario, y usuario no existente)
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("", "Blablabla", user1);
        note2 = new Note("A silly note", "", user1);

        when(userDAO.existsById(1)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(note1));
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(note2));

        note1 = new Note("A silly note", "Blablabla", null);
        note2 = new Note("A silly note", "Blablabla", user1);

        when(userDAO.existsById(1)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteService.saveNote(note1));
        assertThrows(UserNotFoundException.class, () -> noteService.saveNote(note2));
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
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("A NEW (!!!) silly note", "Blablabla (v2)", user1);
        existingNote1 = new Note("A silly note", "Blablabla", user1);
        existingNote1.setNoteID(1L);
        note1.setNoteID(1L);

        when(noteDAO.findById(1)).thenReturn(Optional.of(existingNote1));
        when(userDAO.existsById(1)).thenReturn(true);

        noteService.editNote(note1);

        verify(noteDAO, times(1)).findById(1);
        verify(userDAO, times(1)).existsById(1);
        verify(noteDAO, times(1)).save(existingNote1);
    }

    @Test
    void editNoteWithoutId() {
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("A NEW (!!!) silly note", "Blablabla (v2)", user1);
        existingNote1 = new Note("A silly note", "Blablabla", user1);
        existingNote1.setNoteID(1L);
        note1.setNoteID(null);

        assertThrows(IllegalArgumentException.class, () -> noteService.editNote(note1));
    }

    @Test
    void editNoteWithUserNotFound() {
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("A NEW (!!!) silly note", "Blablabla (v2)", user1);
        existingNote1 = new Note("A silly note", "Blablabla", user1);
        existingNote1.setNoteID(1L);
        note1.setNoteID(1L);

        when(noteDAO.findById(1)).thenReturn(Optional.of(existingNote1));
        when(userDAO.existsById(1)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> noteService.editNote(note1));
    }

    @Test
    void editNoteNotFound() {
        user1 = new User(1L, "panaFu" ,"Fugo", "Pannacotta", null );
        note1 = new Note("A NEW (!!!) silly note", "Blablabla (v2)", user1);
        existingNote1 = new Note("A silly note", "Blablabla", user1);
        existingNote1.setNoteID(1L);
        note1.setNoteID(1L);

        when(noteDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(NoteNotFoundException.class, () -> noteService.editNote(note1));
    }
}