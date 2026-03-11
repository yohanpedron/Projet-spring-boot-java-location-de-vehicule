package com.accenture.service.dto;

import com.accenture.utils.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDto(

        @NotBlank(message = Messages.CLIENT_ADDRESS_STREET_NULLORBLANK)
        String street,

        @NotBlank(message = Messages.CLIENT_ADDRESS_POSTALCODE_NULLORBLANK)
        @Pattern(regexp = "^[0-9]{5}$", message = Messages.CLIENT_ADDRESS_POSTAL_WRONGFORMAT)
        String postalCode,

        @NotBlank(message = Messages.CLIENT_ADDRESS_CITY_NULLORBLANK)
        String city
) {
}
