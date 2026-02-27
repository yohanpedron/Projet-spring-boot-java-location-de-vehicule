package com.accenture.service.dto;

import com.accenture.model.Address;

import java.util.List;

public record ClientResponseDto(
        int id ,
        String firstName,
        String lastName,
        AddressDto addressDto,
        String mail,
        String password,
        String birthday,
        String registerDate,
        List<String> drivingLicenses
) {
}
