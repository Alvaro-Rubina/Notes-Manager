package org.alvarub.notesmanager.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.alvarub.notesmanager.dto.NoteDTO;
import org.alvarub.notesmanager.model.Note;
import org.alvarub.notesmanager.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-06T01:24:40-0300",
    comments = "version: 1.6.0.RC1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDTO noteToNoteDTO(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDTO.NoteDTOBuilder noteDTO = NoteDTO.builder();

        noteDTO.creatorUserName( noteUserUserName( note ) );
        noteDTO.title( note.getTitle() );
        noteDTO.content( note.getContent() );
        noteDTO.creationDate( note.getCreationDate() );

        return noteDTO.build();
    }

    @Override
    public List<NoteDTO> noteListToNoteDTOList(List<Note> notes) {
        if ( notes == null ) {
            return null;
        }

        List<NoteDTO> list = new ArrayList<NoteDTO>( notes.size() );
        for ( Note note : notes ) {
            list.add( noteToNoteDTO( note ) );
        }

        return list;
    }

    private String noteUserUserName(Note note) {
        User user = note.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUserName();
    }
}
