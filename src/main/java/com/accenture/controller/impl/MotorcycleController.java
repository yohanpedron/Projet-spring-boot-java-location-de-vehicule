package com.accenture.controller.impl;

import com.accenture.controller.MotorcycleApi;
import com.accenture.service.CarService;
import com.accenture.service.MotorcycleService;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.dto.MotorcycleRequestDto;
import com.accenture.service.dto.MotorcycleResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class MotorcycleController implements MotorcycleApi {

    private final MotorcycleService motorcycleService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addMotorcycle(@Valid MotorcycleRequestDto motorcycleRequestDto){
        MotorcycleResponseDto motorcycleResponseDto = motorcycleService.addMotorcycle(motorcycleRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(motorcycleResponseDto).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<MotorcycleResponseDto>> motorcycles(){ return ResponseEntity.ok(motorcycleService.findAllMotorcycles()); }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MotorcycleResponseDto> motorcycle(int idMotorcycle){ return ResponseEntity.ok(motorcycleService.findMotorcycleById(idMotorcycle)); }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMotorcycle(int idMotorcycle) {
        motorcycleService.deleteMotorcycle(idMotorcycle);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MotorcycleResponseDto> patchMotorcycle(int idMotorcycle, MotorcycleRequestDto motorcycleRequestDto) {
        MotorcycleResponseDto motorcycleResponseDto = motorcycleService.patchMotorcycle(idMotorcycle, motorcycleRequestDto);
        return ResponseEntity.ok(motorcycleResponseDto);
    }

}
