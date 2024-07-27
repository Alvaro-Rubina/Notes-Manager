package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dao.NoteDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {

    @Mock
    NoteDAO noteDAO;

    @InjectMocks
    NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveNote() {
    }

    @Test
    void findNote() {
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