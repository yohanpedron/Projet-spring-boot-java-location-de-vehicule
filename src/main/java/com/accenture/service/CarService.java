package com.accenture.service;

import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CarService {

    CarResponseDto addCar(@Valid CarRequestDto carRequestDto);

    List<CarResponseDto> findAllCars();

    CarResponseDto findCarById(int idCar);

    void deleteCar(int idCar);

    CarResponseDto patchCar(int idCar, CarRequestDto carRequestDto);
}
