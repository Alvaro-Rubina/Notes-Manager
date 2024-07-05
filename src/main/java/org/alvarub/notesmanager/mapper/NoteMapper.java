package org.alvarub.notesmanager.mapper;

import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    // Mapeos
    @Mapping(source = "user.userName", target = "creatorUserName")
    NoteDTO noteToNoteDTO(Note note);

    List<NoteDTO> noteListToNoteDTOList(List<Note> notes);
}
