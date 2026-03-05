package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public record ClientRequestPatchDto(

        String firstName,

        String lastName,

        AddressDto addressDto,

        @Email(message = "client.mail.wrongformat")
        @Schema(example = "mail@mail.com")
        String mail,

        @Pattern(regexp = "^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$", message = "client.password.wrongformat")
        @Schema(example = "Abcdef1&")
        String password,

        LocalDate birthday,

        List<String> drivingLicenses
) {
}
