package com.accenture.controller;

import com.accenture.controller.advice.ErrorDto;
import com.accenture.service.dto.*;
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
    @PutMapping
    ResponseEntity<Void> addClient(@RequestBody ClientRequestDto clientRequestDto);

    @Operation(summary = "List of all clients")
    @ApiResponse(responseCode = "200", description = "List of all clients")
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> clients();

    @Operation(summary = "Get client by id")
    @ApiResponse(responseCode = "200", description = "Get client by id")
    @ApiResponse(responseCode = "404", description = "Client not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> client(@Parameter(description = "Client's ID", required = true) @PathVariable("id") int idClient);

    @Operation(summary = "Delete client by id")
    @ApiResponse(responseCode = "204", description = "Client deleted")
    @ApiResponse(responseCode = "404", description = "CLient not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@Parameter(description = "Client's ID", required = true) @PathVariable("id") int idClient);

    @Operation(summary = "Modify partially client")
    @ApiResponse(responseCode = "200", description = "Client modified partially")
    @ApiResponse(responseCode = "404", description = "Client not found", content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    @PatchMapping("/{id}")
    ResponseEntity<ClientResponseDto> patchClient(@Parameter(description = "Client's ID", required = true) @PathVariable("id") int idClient, @RequestBody ClientRequestPatchDto clientRequestPatchDto);

}
