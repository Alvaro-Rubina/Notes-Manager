package org.alvarub.rtnotes.mapper;

import org.alvarub.rtnotes.dto.NoteDTO;
import org.alvarub.rtnotes.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    // Mapeos
    @Mapping(source = "user.userName", target = "creatorUserName")
    NoteDTO noteToNoteDTO(Note note);
}
