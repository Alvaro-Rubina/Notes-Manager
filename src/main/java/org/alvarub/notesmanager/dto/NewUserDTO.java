package org.alvarub.notesmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
public class NewUserDTO {

    @Schema(example = "pucciE")
    private String userName;

    @Schema(example = "Enrico")
    private String name;

    @Schema(example = "Pucci")
    private String lastName;
}
