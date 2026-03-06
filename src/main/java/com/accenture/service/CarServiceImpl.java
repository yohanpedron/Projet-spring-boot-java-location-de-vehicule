package com.accenture.service;

import com.accenture.exception.CarException;
import com.accenture.mapper.CarMapper;
import com.accenture.model.Admin;
import com.accenture.model.Car;
import com.accenture.repository.CarDao;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {

    private final CarDao carDao;
    private final CarMapper carMapper;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public CarResponseDto addCar(@Valid CarRequestDto carRequestDto) throws CarException {
        verifyCar(carRequestDto);
        Car carMapped = carMapper.toCar(carRequestDto);
        carMapped.setDriverLicencesAvailable(List.of("B","D1"));
        Car saved = carDao.save(carMapped);
        return carMapper.toCarResponseDto(saved);
    }

    @Override
    public List<CarResponseDto> findAllCars(){
        List<Car> cars = carDao.findAll();
        return cars.stream().map(carMapper::toCarResponseDto).toList();
    }

    @Override
    public CarResponseDto findCarById(int idCar){
        Car car = carDao.findById(idCar).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage("car.id.notfound")));
        return carMapper.toCarResponseDto(car);
    }

    @Override
    public void deleteCar(int idCar){
        if (!carDao.existsById(idCar))
            throw new EntityNotFoundException(messageSourceAccessor.getMessage(""));
        carDao.deleteById(idCar);
    }

    @Override
    public CarResponseDto patchCar(int idCar, CarRequestDto carRequestDto){
        Car car = carDao.findById(idCar).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage("car.id.notfound")));
        Car saved = carDao.save(car);
        return carMapper.toCarResponseDto(saved);
    }

    private void verifyCar(CarRequestDto carRequestDto) {
        if (carRequestDto == null)
            throw new CarException(messageSourceAccessor.getMessage("car.null"));
    }
}
