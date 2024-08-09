package org.alvarub.notesmanager.service;

import org.alvarub.notesmanager.dto.NewNoteDTO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.model.Note;
import java.util.List;

public interface INoteService {

    public void saveNote(NewNoteDTO newNoteDTO);
    public NoteDTO findNote(int id);
    public List<NoteDTO> getNotes();
    public void deleteNote(int id);
    public void editNote(int id, NewNoteDTO newNoteDTO);
}
