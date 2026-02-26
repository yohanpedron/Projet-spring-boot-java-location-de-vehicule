package com.accenture.controller.impl;

import com.accenture.controller.ClientApi;
import com.accenture.service.ClientService;
import com.accenture.service.dto.ClientResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<List<ClientResponseDto>> clients(){return ResponseEntity.ok(clientService.findAll());}

    @Override
    public ResponseEntity<ClientResponseDto> client(int idClient){
        return ResponseEntity.ok(clientService.findById(idClient));
    }

}
