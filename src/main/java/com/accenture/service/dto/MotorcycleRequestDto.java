package com.accenture.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MotorcycleRequestDto(
        @NotBlank(message = "motorcycle.brand.nullorblank")
        String brand,

        @NotBlank(message = "motorcycle.model.nullorblank")
        String model,

        @NotBlank(message = "motorcycle.color.nullorblank")
        String color,

        @NotBlank(message = "motorcycle.type.nullorblank")
        String type,

        @Min(value = 0, message = "motorcycle.dailyBaseRentalRate.negative")
        double dailyBaseRentalRate,

        @Min(value = 0, message = "motorcycle.kilometers.negative")
        double kilometers,

        boolean active,
        boolean removedFromParc,

        @Min(value = 0, message = "motorcycle.numberofcylinders.negative")
        @Schema(example = "100")
        int numberOfCylinders,

        @NotBlank(message = "motorcycle.enginesize.nullorblank")
        String engineSize,

        @Min(value = 0, message = "motorcycle.weight.negative")
        double weight,

        @Min(value = 0, message = "motorcycle.power.negative")
        double power,

        @Min(value = 0, message = "motorcycle.saddleheight.negative")
        double saddleHeight,

        @NotBlank(message = "motorcycle.transmission.nullorblank")
        String transmission
) {
}
