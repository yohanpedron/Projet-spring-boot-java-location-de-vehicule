package com.accenture.controller.impl;

import com.accenture.controller.VehicleApi;
import com.accenture.service.VehicleService;
import com.accenture.service.dto.MotorcycleResponseDto;
import com.accenture.service.dto.VehicleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleController implements VehicleApi {

    private final VehicleService vehicleService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<VehicleResponseDto>> vehicles(){ return ResponseEntity.ok(vehicleService.findAllVehicles()); }

}
