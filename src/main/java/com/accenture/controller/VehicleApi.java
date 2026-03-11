package com.accenture.controller;

import com.accenture.service.dto.MotorcycleResponseDto;
import com.accenture.service.dto.VehicleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Vehicles", description = "API of vehicles management")
@RequestMapping("/vehicles")
public interface VehicleApi {
    @Operation(summary = "List of all vehicles")
    @ApiResponse(responseCode = "200", description = "List of all vehicles")
    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> vehicles();
}
