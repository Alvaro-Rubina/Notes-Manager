package org.alvarub.notesmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewNoteDTO {

    @Schema(description = "Título de la nota")
    private String title;

    @Schema(description = "Contenido de la nota")
    private String content;

    @Schema(description = "ID del usuario dueño de la nota", example = "1")
    private Long creatorID;
}
