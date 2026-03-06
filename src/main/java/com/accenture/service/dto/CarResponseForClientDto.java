package com.accenture.service.dto;

import java.util.List;

public record CarResponseForClientDto(

        String brand,
        String model,
        String color,
        String type,
        List<String> driverLicencesAvailable,

        int numberOfPlaces,
        String fuelType,
        int numberOfDoors,
        String transmission,
        boolean airConditioning,
        int numberOfLuggage
) {
}
