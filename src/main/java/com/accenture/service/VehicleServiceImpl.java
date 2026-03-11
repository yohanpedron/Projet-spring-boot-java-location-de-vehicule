package com.accenture.service;

import com.accenture.mapper.VehicleMapper;
import com.accenture.model.Motorcycle;
import com.accenture.model.Vehicle;
import com.accenture.repository.VehicleDao;
import com.accenture.service.dto.MotorcycleResponseDto;
import com.accenture.service.dto.VehicleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleDao vehicleDao;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleResponseDto> findAllVehicles(){
        List<Vehicle> vehicle = vehicleDao.findAll();
        return vehicle
                .stream()
                .map(vehicleMapper::toVehicleResponseDto)
                .toList();
    }
}
