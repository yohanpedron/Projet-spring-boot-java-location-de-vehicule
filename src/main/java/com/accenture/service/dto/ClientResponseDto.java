package com.accenture.service.dto;

import com.accenture.model.Address;

import java.time.LocalDate;
import java.util.List;

public record ClientResponseDto(
        int id ,
        String firstName,
        String lastName,
        Address address,
        String mail,
        String password,
        LocalDate birthday,
        LocalDate registerDate,
        List<String> drivingLicenses
) {
}
