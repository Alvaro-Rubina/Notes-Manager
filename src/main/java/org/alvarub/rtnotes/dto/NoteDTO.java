package org.alvarub.rtnotes.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class NoteDTO {

    // Attributes
    private String title;
    private String content;
    private LocalDate creationDate;
    private String creatorUserName;
}
