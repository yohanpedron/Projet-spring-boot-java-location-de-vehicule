package com.accenture.service.dto;

import com.accenture.utils.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MotorcycleRequestDto(
        @NotBlank(message = Messages.MOTORCYCLE_BRAND_NULLORBLANK)
        String brand,

        @NotBlank(message = Messages.MOTORCYCLE_MODEL_NULLORBLANK)
        String model,

        @NotBlank(message = Messages.MOTORCYCLE_COLOR_NULLORBLANK)
        String color,

        @NotBlank(message = Messages.MOTORCYCLE_TYPE_NULLORBLANK)
        String type,

        @Min(value = 0, message = Messages.MOTORCYCLE_DAILYBASERENTALRATE_NEGATIVE)
        double dailyBaseRentalRate,

        @Min(value = 0, message = Messages.MOTORCYCLE_KILOMETERS_NEGATIVE)
        double kilometers,

        boolean active,
        boolean removedFromParc,

        @Min(value = 0, message = Messages.MOTORCYCLE_NUMBEROFCYLINDERS_NEGATIVE)
        @Schema(example = "100")
        int numberOfCylinders,

        @NotBlank(message = Messages.MOTORCYCLE_ENGINESIZE_NULLORBLANK)
        String engineSize,

        @Min(value = 0, message = Messages.MOTORCYCLE_WEIGHT_NEGATIVE)
        double weight,

        @Min(value = 0, message = Messages.MOTORCYCLE_POWER_NEGATIVE)
        double power,

        @Min(value = 0, message = Messages.MOTORCYCLE_SADDLEHEIGHT_NEGATIVE)
        double saddleHeight,

        @NotBlank(message = Messages.MOTORCYCLE_TRANSMISSION_NULLORBLANK)
        String transmission
) {
}
