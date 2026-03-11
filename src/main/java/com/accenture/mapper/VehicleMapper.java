package com.accenture.mapper;

import com.accenture.model.Vehicle;
import com.accenture.service.dto.VehicleResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleResponseDto toVehicleResponseDto(Vehicle vehicle);

}
