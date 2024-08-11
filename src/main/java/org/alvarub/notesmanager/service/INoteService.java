package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.model.dto.NewNoteDTO;
import org.alvarub.notesmanager.model.dto.NoteDTO;

import java.util.List;

public interface INoteService {

    public void saveNote(NewNoteDTO newNoteDTO);
    public NoteDTO findNote(int id);
    public List<NoteDTO> getNotes();
    public void deleteNote(int id);
    public void editNote(int id, NewNoteDTO newNoteDTO);
}
