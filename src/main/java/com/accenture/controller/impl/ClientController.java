package com.accenture.controller.impl;

import com.accenture.controller.ClientApi;
import com.accenture.service.ClientService;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PutMapping
    @Override
    public ResponseEntity<Void> addClient(@Valid ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto = clientService.addClient(clientRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientResponseDto).toUri();
        return ResponseEntity.created(location).build();
    }

}
