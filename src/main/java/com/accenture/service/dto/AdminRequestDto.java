package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdminRequestDto(

        @NotBlank(message = "admin.firstname.nullorblank")
        @Valid
        String firstName,

        @NotBlank(message = "admin.lastname.nullorblank")
        @Valid
        String lastName,

        @NotBlank(message = "admin.function.nullorblank")
        @Valid
        String function,

        @NotBlank(message = "admin.mail.nullorblank")
        @Email(message = "admin.mail.wrongformat")
        @Schema(example = "mail@mail.com")
        @Valid
        String mail,

        @NotBlank(message = "admin.password.nullorblank")
        @Pattern(regexp = "^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$", message = "admin.password.wrongformat")
        @Schema(example = "Abcdef1&")
        @Valid
        String password
) {
}
