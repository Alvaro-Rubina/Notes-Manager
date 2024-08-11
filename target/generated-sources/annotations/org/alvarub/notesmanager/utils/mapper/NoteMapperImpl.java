package org.alvarub.notesmanager.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.alvarub.notesmanager.model.dto.NewNoteDTO;
import org.alvarub.notesmanager.model.dto.NoteDTO;
import org.alvarub.notesmanager.model.entity.Note;
import org.alvarub.notesmanager.model.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T01:08:15-0300",
    comments = "version: 1.6.0.RC1, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public Note newNoteDTOToNote(NewNoteDTO newNoteDTO) {
        if ( newNoteDTO == null ) {
            return null;
        }

        Note note = new Note();

        note.setContent( newNoteDTO.content() );
        note.setTitle( newNoteDTO.title() );

        return note;
    }

    @Override
    public NoteDTO noteToNoteDTO(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDTO.NoteDTOBuilder noteDTO = NoteDTO.builder();

        noteDTO.creatorUserName( noteUserUserName( note ) );
        noteDTO.noteID( note.getNoteID() );
        noteDTO.title( note.getTitle() );
        noteDTO.content( note.getContent() );
        noteDTO.characterCount( note.getCharacterCount() );
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
