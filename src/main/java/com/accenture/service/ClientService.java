package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientService {

    ClientResponseDto addClient(ClientRequestDto clientRequestDto) throws ClientException;

}
