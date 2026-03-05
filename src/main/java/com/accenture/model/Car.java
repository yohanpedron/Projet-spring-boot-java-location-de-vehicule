package com.accenture.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Vehicle {
    private int numberOfPlaces;
    private String fuelType;
    private int numberOfDoors;
    private String transmission;
    private boolean airConditioning;
    private int numberOfLuggage;
}
