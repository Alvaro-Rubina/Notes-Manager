package org.alvarub.notesmanager.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserDTO {

    private Long userID;
    private String userName;
    private String name;
    private String lastName;
    private List<NoteDTO> notes;
}
