package org.alvarub.notesmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class NewNoteDTO {

    @Schema(example = "A silly note")
    private String title;

    @Schema(example = "Blablabla")
    private String content;

    @Schema(example = "1")
    private Long creatorID;
}
