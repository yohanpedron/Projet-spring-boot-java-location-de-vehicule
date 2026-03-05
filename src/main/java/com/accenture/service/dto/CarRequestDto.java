package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CarRequestDto(


        String brand,
        String model,
        String color,
        String type,
        String driverLicencesAvailable,
        double dailyBaseRentalRate,
        double kilometers,
        boolean active,
        boolean removedFromParc,

        @Schema(example = "5")
        int numberOfPlaces,

        String fuelType,

        @Schema(example = "3")
        int numberOfDoors,

        String transmission,
        boolean airConditioning,

        @Schema(example = "1")
        int numberOfLuggage
) {
}
