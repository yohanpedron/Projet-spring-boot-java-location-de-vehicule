package com.accenture.service;

import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;

public interface ClientService {
    ClientResponseDto addClient(ClientRequestDto clientRequestDto);
}
