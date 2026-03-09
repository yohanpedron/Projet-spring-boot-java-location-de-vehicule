package com.accenture.service.dto;

import com.accenture.utils.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CarRequestDto(

        @NotBlank(message = Messages.CAR_BRAND_NULLORBLANK)
        String brand,

        @NotBlank(message = Messages.CAR_MODEL_NULLORBLANK)
        String model,

        @NotBlank(message = Messages.CAR_COLOR_NULLORBLANK)
        String color,

        @NotBlank(message = Messages.CAR_TYPE_NULLORBLANK)
        String type,

        @Min(value = 0, message = Messages.CAR_DAILYBASERENTALRATE_NEGATIVE)
        double dailyBaseRentalRate,

        @Min(value = 0, message = Messages.CAR_KILOMETERS_NEGATIVE)
        double kilometers,

        boolean active,
        boolean removedFromParc,

        @Schema(example = "5")
        @Min(value = 5, message = Messages.CAR_NUMBEROFPLACES_INFERIORTO5)
        int numberOfPlaces,

        @NotBlank(message = Messages.CAR_FUELTYPE_NULLORBLANK)
        String fuelType,

        @Schema(example = "3")
        @Min(value = 3, message = Messages.CAR_NUMBEROFDOORS_INFERIORTO3)
        int numberOfDoors,

        @NotBlank(message = Messages.CAR_TRANSMISSION_NULLORBLANK)
        String transmission,

        boolean airConditioning,

        @Schema(example = "1")
        @Min(value = 1, message = Messages.CAR_NUMBEROFLUGGAGE_INFERIORTO1)
        int numberOfLuggage
) {
}
