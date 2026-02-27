package com.accenture.service.dto;

import com.accenture.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record ClientRequestDto(

        @NotBlank(message = "client.firstname.nullorblank")
        String firstName,

        @NotBlank(message = "client.lastname.nullorblank")
        String lastName,

        @NotNull(message = "client.address.null")
        @Valid
        AddressDto addressDto,

        @NotBlank(message = "client.mail.nullorblank")
        @Email
        String mail,

        @NotBlank(message = "client.password.nullorblank")
        String password,

        LocalDate birthday,

        @NotBlank(message = "client.registerdate.nullorblank")
        String registerDate,

        @NotEmpty(message = "client.drivinglicences.empty")
        List<String> drivingLicenses
) {
}
