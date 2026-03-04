package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admins", description = "API of admins management")
@RequestMapping("/admins")
public interface AdminApi {

    @Operation(summary = "Add a new admin")
    @ApiResponse(responseCode = "200", description = "Admin created")
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PutMapping
    ResponseEntity<Void> addAdmin(@RequestBody AdminRequestDto adminRequestDto);

    @Operation(summary = "List of all admins")
    @ApiResponse(responseCode = "200", description = "List of all admins")
    @GetMapping
    ResponseEntity<List<AdminResponseDto>> admins();

    @Operation(summary = "Get admin by id")
    @ApiResponse(responseCode = "200", description = "Get admin by id")
    @ApiResponse(responseCode = "404", description = "Admin not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<AdminResponseDto> admin(@Parameter(description = "Admin's ID", required = true) @PathVariable("id") int idAdmin);

    @Operation(summary = "Delete admin by id")
    @ApiResponse(responseCode = "204", description = "Admin deleted")
    @ApiResponse(responseCode = "404", description = "Admin not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAdmin(@Parameter(description = "Admin's ID", required = true) @PathVariable("id") int idAdmin);

    @Operation(summary = "Modify partially admin")
    @ApiResponse(responseCode = "200", description = "Admin modified partially")
    @ApiResponse(responseCode = "404", description = "Admin not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<AdminResponseDto> patchAdmin(@Parameter(description = "Admin's ID", required = true) @PathVariable("id") int idAdmin, @RequestBody AdminRequestDto adminRequestDto);

}
