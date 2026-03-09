package com.accenture.service.dto;

import com.accenture.model.Address;
import com.accenture.utils.Messages;
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

        @NotBlank(message = Messages.CLIENT_FIRSTNAME_NULLORBLANK)
        @Valid
        String firstName,

        @NotBlank(message = Messages.CLIENT_LASTNAME_NULLORBLANK)
        @Valid
        String lastName,

        @NotNull(message = Messages.CLIENT_ADDRESS_NULL)
        @Valid
        AddressDto addressDto,

        @NotBlank(message = Messages.CLIENT_MAIL_NULLORBLANK)
        @Email(message = Messages.CLIENT_MAIL_WRONGFORMAT)
        @Schema(example = "mail@mail.com")
        @Valid
        String mail,

        @NotBlank(message = Messages.CLIENT_PASSWORD_NULLORBLANK)
        @Pattern(regexp = "^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$", message = Messages.CLIENT_PASSWORD_WRONGFORMAT)
        @Schema(example = "Abcdef1&")
        @Valid
        String password,


        LocalDate birthday,

        @NotNull(message = Messages.CLIENT_DRIVINGLICENCES_NULL)
        List<String> drivingLicenses
) {
}
