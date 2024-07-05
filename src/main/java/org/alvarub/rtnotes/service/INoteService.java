package org.alvarub.rtnotes.service;

import org.alvarub.rtnotes.dto.NoteDTO;
import org.alvarub.rtnotes.model.Note;
import java.util.List;

public interface INoteService {

    public void saveNote(Note note);
    public NoteDTO findNote(int id);
    public List<NoteDTO> getNotes();
    public void deleteNote(int id);
    public void editNote(Note note);
}
