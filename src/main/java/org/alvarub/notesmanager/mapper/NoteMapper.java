package org.alvarub.notesmanager.mapper;

import org.alvarub.notesmanager.dto.NewNoteDTO;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    // Mapeos
    Note newNoteDTOToNote (NewNoteDTO newNoteDTO);

    @Mapping(source = "user.userName", target = "creatorUserName")
    NoteDTO noteToNoteDTO(Note note);

    List<NoteDTO> noteListToNoteDTOList(List<Note> notes);
}
