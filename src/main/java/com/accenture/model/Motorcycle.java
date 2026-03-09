package com.accenture.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorcycle extends Vehicle{
    private int numberOfCylinders;
    private int engineSize;
    private double weight;
    private double power;
    private double saddleHeight;
    private String transmission;

}
