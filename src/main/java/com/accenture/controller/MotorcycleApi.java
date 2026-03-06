package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.dto.MotorcycleRequestDto;
import com.accenture.service.dto.MotorcycleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Motorcycles", description = "API of motorcycles management")
@RequestMapping("/motorcycles")
public interface MotorcycleApi {
    @Operation(summary = "Add a new motorcycles")
    @ApiResponse(responseCode = "200", description = "Motorcycle created")
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping
    ResponseEntity<Void> addMotorcycle(@RequestBody MotorcycleRequestDto motorcycleRequestDto);

    @Operation(summary = "List of all motorcycles")
    @ApiResponse(responseCode = "200", description = "List of all motorcycles")
    @GetMapping
    public ResponseEntity<List<MotorcycleResponseDto>> motorcycles();

    @Operation(summary = "Get motorcycle by id")
    @ApiResponse(responseCode = "200", description = "Get motorcycle by id")
    @ApiResponse(responseCode = "404", description = "Motorcycle not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<MotorcycleResponseDto> motorcycle(@Parameter(description = "motorcycle's ID", required = true) @PathVariable("id") int idMotorcycle);

    @Operation(summary = "Delete motorcycle by id")
    @ApiResponse(responseCode = "204", description = "Motorcycle deleted")
    @ApiResponse(responseCode = "404", description = "Motorcycle not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMotorcycle(@Parameter(description = "motorcycle's ID", required = true) @PathVariable("id") int idMotorcycle);

    @Operation(summary = "Modify partially motorcycle")
    @ApiResponse(responseCode = "200", description = "Motorcycle modified partially")
    @ApiResponse(responseCode = "404", description = "Motorcycle not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<MotorcycleResponseDto> patchMotorcycle(@Parameter(description = "motorcycle's ID", required = true) @PathVariable("id") int idMotorcycle, @RequestBody MotorcycleRequestDto motorcycleRequestDto);
}
