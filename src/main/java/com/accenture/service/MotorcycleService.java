package com.accenture.service;

import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.dto.MotorcycleRequestDto;
import com.accenture.service.dto.MotorcycleResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface MotorcycleService {
    MotorcycleResponseDto addMotorcycle(@Valid MotorcycleRequestDto motorcycleRequestDto);

    List<MotorcycleResponseDto> findAllMotorcycles();

    MotorcycleResponseDto findMotorcycleById(int idMotorcycle);

    void deleteMotorcycle(int idMotorcycle);

    MotorcycleResponseDto patchMotorcycle(int idMotorcycle, MotorcycleRequestDto motorcycleRequestDto);
}
