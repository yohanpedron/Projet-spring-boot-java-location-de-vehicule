package com.accenture.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDto(

        @NotBlank(message = "client.address.street.nullorblank")
        String street,

        @NotBlank(message = "client.address.postalcode.nullorblank")
        String postalCode,

        @NotBlank(message = "client.address.city.nullorblank")
        String city
) {
}
