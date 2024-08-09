package org.alvarub.notesmanager.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class NoteDTO {

    private Long noteID;
    private String title;
    private String content;
    private int characterCount;
    private LocalDate creationDate;
    private String creatorUserName;
}
