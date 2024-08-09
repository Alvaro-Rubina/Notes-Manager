package org.alvarub.notesmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
public class NewUserDTO {

    @Schema(description = "Username")
    private String userName;

    @Schema(description = "Nombre")
    private String name;

    @Schema(description = "Apellido")
    private String lastName;
}
