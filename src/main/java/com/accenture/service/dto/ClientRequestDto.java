package com.accenture.service.dto;

import com.accenture.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ClientRequestDto(
        @NotBlank(message = "client.firstname.null")
        String firstName,

        @NotBlank(message = "client.lastname.null")
        String lastName,

        @NotNull(message = "client.address.null")
        @Valid
        AddressDto addressDto,

        @NotBlank(message = "client.mail.null")
        @Email
        String mail,

        @NotBlank(message = "client.password.null")
        String password,

        @NotBlank(message = "client.birthday.null")
        String birthday,

        @NotBlank(message = "client.registerdate.null")
        String registerDate,

        @NotEmpty(message = "client.drivinglicences.empty")
        List<String> drivingLicenses
) {
}
