package org.alvarub.notesmanager.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record NewNoteDTO(@Schema(example = "A silly note") String title,
                         @Schema(example = "Blablabla") String content,
                         @Schema(example = "1") Long creatorID) {

}
