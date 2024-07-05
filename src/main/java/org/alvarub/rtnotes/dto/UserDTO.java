package org.alvarub.rtnotes.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserDTO {

    // Attributes
    private String userName;
    private String name;
    private String lastName;
    private List<NoteDTO> notes;
}
