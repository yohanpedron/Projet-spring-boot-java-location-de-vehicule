package com.accenture.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDto(

        @NotBlank(message = "client.address.street.nullorblank")
        String street,

        @NotBlank(message = "client.address.postalcode.nullorblank")
        @Pattern(regexp = "^[0-9]{5}$", message = "client.address.postalcode.wrongformat")
        String postalCode,

        @NotBlank(message = "client.address.city.nullorblank")
        String city
) {
}
