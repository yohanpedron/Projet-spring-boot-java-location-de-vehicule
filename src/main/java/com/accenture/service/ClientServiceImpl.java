package com.accenture.service;

import com.accenture.mapper.ClientMapper;
import com.accenture.model.Client;
import com.accenture.repository.ClientDao;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService{

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDto addClient(ClientRequestDto clientRequestDto){
        verify(clientRequestDto);
        Client saved = clientDao.save(clientMapper.toClient(clientRequestDto));
        return clientMapper.toClientResponseDto(saved);
    }

    private void verify(ClientRequestDto clientRequestDto) {

    }
}
