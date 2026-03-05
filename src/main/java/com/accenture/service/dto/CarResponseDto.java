package com.accenture.service.dto;

public record CarResponseDto(
        int id ,
        String brand,
        String model,
        String color,
        String type,
        String driverLicencesAvailable,
        double dailyBaseRentalRate,
        double kilometers,
        boolean active,
        boolean removedFromParc,

        int numberOfPlaces,
        String fuelType,
        int numberOfDoors,
        String transmission,
        boolean airConditioning,
        int numberOfLuggage
) {
}
