package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vehicles", description = "API of vehicles management")
@RequestMapping("/vehicles")
public interface CarApi {

    @Operation(summary = "Add a new car")
    @ApiResponse(responseCode = "200", description = "Vehicle created")
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping
    ResponseEntity<Void> addCar(@RequestBody CarRequestDto carRequestDto);

    @Operation(summary = "List of all cars")
    @ApiResponse(responseCode = "200", description = "List of all cars")
    @GetMapping
    public ResponseEntity<List<CarResponseDto>> cars();

    @Operation(summary = "Get car by id")
    @ApiResponse(responseCode = "200", description = "Get car by id")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<CarResponseDto> car(@Parameter(description = "Car's ID", required = true) @PathVariable("id") int idCar);

    @Operation(summary = "Delete car by id")
    @ApiResponse(responseCode = "204", description = "Car deleted")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(@Parameter(description = "Car's ID", required = true) @PathVariable("id") int idCar);

    @Operation(summary = "Modify partially car")
    @ApiResponse(responseCode = "200", description = "Car modified partially")
    @ApiResponse(responseCode = "404", description = "Car not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<CarResponseDto> patchCar(@Parameter(description = "Car's ID", required = true) @PathVariable("id") int idCar, @RequestBody CarRequestDto carRequestDto);

}
