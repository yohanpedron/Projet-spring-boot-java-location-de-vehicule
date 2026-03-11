package com.accenture.service.fake;

import com.accenture.mapper.CarMapper;
import com.accenture.model.Car;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;

import java.util.concurrent.atomic.AtomicInteger;

public class FakeCarMapper implements CarMapper {
    private final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Car toCar(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setId(seq.getAndIncrement());
        car.setNumberOfPlaces(carRequestDto.numberOfPlaces());
        car.setTransmission(carRequestDto.transmission());
        car.setFuelType(carRequestDto.fuelType());
        car.setAirConditioning(carRequestDto.airConditioning());
        car.setNumberOfDoors(carRequestDto.numberOfDoors());
        car.setNumberOfLuggage(carRequestDto.numberOfLuggage());
        return car;
    }

    @Override
    public CarResponseDto toCarResponseDto(Car car) {
        return new CarResponseDto(

                car.getNumberOfPlaces(),
                car.getFuelType(),
                car.getNumberOfDoors(),
                car.getTransmission(),
                car.isAirConditioning(),
                car.getNumberOfLuggage()
               );
    }
}
