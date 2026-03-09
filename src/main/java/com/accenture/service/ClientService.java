package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.service.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientService {

    ClientResponseDto addClient(ClientRequestDto clientRequestDto) throws ClientException;

    List<ClientResponseForAdminDto> findAllClients();

    ClientResponseDto findClientById(int idClient);

    void deleteClient(int idClient);

    ClientResponseDto modifyPartiallyClient(int idClient, ClientRequestPatchDto clientRequestPatchDto);
}
