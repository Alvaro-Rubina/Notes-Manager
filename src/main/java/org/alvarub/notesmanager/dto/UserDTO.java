package org.alvarub.notesmanager.dto;

import lombok.*;

import java.util.List;

@Builder
public record UserDTO(Long userID,
                       String userName,
                       String name,
                       String lastName,
                       List<NoteDTO> notes) {
}
