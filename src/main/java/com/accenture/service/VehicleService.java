package com.accenture.service;

import com.accenture.service.dto.VehicleResponseDto;

import java.util.List;

public interface VehicleService {
    List<VehicleResponseDto> findAllVehicles();
}
