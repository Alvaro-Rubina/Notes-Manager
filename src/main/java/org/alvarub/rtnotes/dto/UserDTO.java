package org.alvarub.rtnotes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {

    // Attributes
    private String userName;
    private String name;
    private String lastName;
    private List<NoteDTO> notes;
}
