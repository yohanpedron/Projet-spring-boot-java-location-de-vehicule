package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdminRequestPatchDto(

        String firstName,

        String lastName,


        String function,

        @Email(message = "admin.mail.wrongformat")
        @Schema(example = "mail@mail.com")
        String mail,

        @Pattern(regexp = "^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$", message = "admin.password.wrongformat")
        @Schema(example = "Abcdef1&")
        String password
) {

}
