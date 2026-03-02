package com.accenture.service.dto;

import com.accenture.model.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record ClientRequestDto(

        @NotBlank(message = "client.firstname.nullorblank")
        @Valid
        String firstName,

        @NotBlank(message = "client.lastname.nullorblank")
        @Valid
        String lastName,

        @NotNull(message = "client.address.null")
        @Valid
        AddressDto addressDto,

        @NotBlank(message = "client.mail.nullorblank")
        @Email(message = "client.mail.wrongformat")
        @Schema(example = "mail@mail.com")
        @Valid
        String mail,

        @NotBlank(message = "client.password.nullorblank")
        @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[&#@_§-]).{8,16}$", message = "client.password.wrongformat")
        @Schema(example = "Abcdef1&")
        @Valid
        String password,

        LocalDate birthday,

        @NotNull(message = "client.drivinglicences.null")
        List<String> drivingLicenses
) {
}
