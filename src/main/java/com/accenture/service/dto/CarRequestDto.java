package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CarRequestDto(

        @NotBlank(message = "car.brand.nullorblank")
        String brand,

        @NotBlank(message = "car.model.nullorblank")
        String model,

        @NotBlank(message = "car.color.nullorblank")
        String color,

        @NotBlank(message = "car.type.nullorblank")
        String type,

        @Min(value = 0, message = "car.dailyBaseRentalRate.negative")
        double dailyBaseRentalRate,

        @Min(value = 0, message = "car.kilometers.negative")
        double kilometers,

        boolean active,
        boolean removedFromParc,

        @Schema(example = "5")
        @Min(value = 1, message = "car.numberOfPlaces.inferiorto1")
        int numberOfPlaces,

        @NotBlank(message = "car.fuelType.nullorblank")
        String fuelType,

        @Schema(example = "3")
        @Min(value = 3, message = "car.numberOfDoors.inferiorto3")
        int numberOfDoors,

        @NotBlank(message = "car.transmission.nullorblank")
        String transmission,

        boolean airConditioning,

        @Schema(example = "1")
        @Min(value = 0, message = "car.numberOfLuggage.inferiorto1")
        int numberOfLuggage
) {
}
