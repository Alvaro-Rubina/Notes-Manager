package org.alvarub.notesmanager.utils.mapper;

import org.alvarub.notesmanager.model.dto.NewNoteDTO;
import org.alvarub.notesmanager.model.dto.NoteDTO;
import org.alvarub.notesmanager.model.entity.Note;
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
