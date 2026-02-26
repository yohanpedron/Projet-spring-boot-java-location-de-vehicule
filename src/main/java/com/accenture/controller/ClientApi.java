package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clients", description = "API of clients management")
@RequestMapping("/clients")
public interface ClientApi {

    @Operation(summary = "Add a new client")
    @ApiResponse(responseCode = "200", description = "Client created")
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PostMapping
    ResponseEntity<Void> addClient(@RequestBody ClientRequestDto clientRequestDto);

    @Operation(summary = "List all clients")
    @ApiResponse(responseCode = "200", description = "Clients's list")
    @GetMapping
    ResponseEntity<List<ClientResponseDto>> clients();

    @Operation(summary = "List a client by his id")
    @ApiResponse(responseCode = "200", description = "Client find")
    @ApiResponse(responseCode = "404", description = "Client not find",content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> client(@Parameter(description = "ID de la radio", required = true) @PathVariable("id") int idClient);
}
