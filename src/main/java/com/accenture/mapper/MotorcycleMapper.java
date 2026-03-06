package com.accenture.mapper;

import com.accenture.model.Motorcycle;
import com.accenture.service.dto.MotorcycleRequestDto;
import com.accenture.service.dto.MotorcycleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotorcycleMapper {

    Motorcycle toMotorcycle(MotorcycleRequestDto motorcycleRequestDto);
    MotorcycleResponseDto toMotorcycleResponseDto(Motorcycle motorcycle);
}
