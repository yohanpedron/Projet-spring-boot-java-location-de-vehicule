package com.accenture.service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MotorcycleResponseDto(

        String brand,
        String model,
        String color,
        String type,
        List<String> driverLicencesAvailable,

        double dailyBaseRentalRate,
        double kilometers,
        boolean active,
        boolean removedFromParc,

        int numberOfCylinders,
        String engineSize,
        double weight,
        double power,
        double saddleHeight,
        String transmission
) {
}
