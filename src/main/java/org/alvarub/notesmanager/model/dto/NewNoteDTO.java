package org.alvarub.notesmanager.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewNoteDTO(@Schema(example = "A silly note") @NotBlank(message = "Title is mandatory") String title,
                         @Schema(example = "Blablabla") @NotBlank(message = "Content is mandatory") @Size(max = 500, message = "Content must be at most 500 characters") String content,
                         @Schema(example = "1") @NotNull(message = "CreatorID is mandatory") Long creatorID) {

}
