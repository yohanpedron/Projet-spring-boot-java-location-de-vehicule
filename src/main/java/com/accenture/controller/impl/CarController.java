package com.accenture.controller.impl;

import com.accenture.controller.CarApi;
import com.accenture.service.CarService;
import com.accenture.service.dto.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class CarController implements CarApi {

    private final CarService carService;

    @Override
    public ResponseEntity<Void> addCar(@Valid CarRequestDto carRequestDto){
        CarResponseDto carResponseDto = carService.addCar(carRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carResponseDto).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<List<CarResponseDto>> cars(){ return ResponseEntity.ok(carService.findAllCars()); }

    @Override
    public ResponseEntity<CarResponseDto> car(int idCar){ return ResponseEntity.ok(carService.findCarById(idCar)); }

    @Override
    public ResponseEntity<Void> deleteCar(int idCar) {
        carService.deleteCar(idCar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<CarResponseDto> patchCar(int idCar, CarRequestDto carRequestDto) {
        CarResponseDto carResponseDto = carService.patchCar(idCar, carRequestDto);
        return ResponseEntity.ok(carResponseDto);
    }
}
