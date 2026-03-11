package com.accenture.service.dto;

import java.util.List;

public record VehicleResponseDto(
        int id ,
        String brand,
        String model,
        String color,
        String type,
        List<String> driverLicencesAvailable,
        double dailyBaseRentalRate,
        double kilometers,
        boolean active,
        boolean removedFromParc
) {
}
