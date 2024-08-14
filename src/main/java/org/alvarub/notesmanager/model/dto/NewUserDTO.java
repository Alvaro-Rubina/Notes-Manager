package org.alvarub.notesmanager.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record NewUserDTO(@Schema(example = "pucciE") @NotBlank(message = "Username is mandatory") String userName,
                         @Schema(example = "Enrico") @NotBlank(message = "Name is mandatory") String name,
                         @Schema(example = "Pucci")  @NotBlank(message = "Last name is mandatory") String lastName) {

}
