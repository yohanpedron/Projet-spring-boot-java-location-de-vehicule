package com.accenture.mapper;

import com.accenture.model.Car;
import com.accenture.model.Vehicle;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toCar(CarRequestDto carRequestDto);
    CarResponseDto toCarResponseDto(Car car);


}
