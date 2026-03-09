package com.accenture.controller.impl;

import com.accenture.controller.ClientApi;
import com.accenture.service.ClientService;
import com.accenture.service.dto.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {


    private final ClientService clientService;

    @Override
    public ResponseEntity<Void> addClient(@Valid ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto = clientService.addClient(clientRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientResponseDto).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ClientResponseForAdminDto>> clients(){ return ResponseEntity.ok(clientService.findAllClients()); }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    public ResponseEntity<ClientResponseDto> client(int idClient){ return ResponseEntity.ok(clientService.findClientById(idClient)); }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    public ResponseEntity<Void> deleteClient(int idClient) {
        clientService.deleteClient(idClient);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    public ResponseEntity<ClientResponseDto> patchClient(int idClient, ClientRequestPatchDto clientRequestPatchDto) {
        ClientResponseDto clientResponseDto = clientService.modifyPartiallyClient(idClient, clientRequestPatchDto);
        return ResponseEntity.ok(clientResponseDto);
    }
}
