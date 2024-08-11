package org.alvarub.notesmanager.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record NewUserDTO(@Schema(example = "pucciE") String userName,
                         @Schema(example = "Enrico") String name,
                         @Schema(example = "Pucci") String lastName) {

}
