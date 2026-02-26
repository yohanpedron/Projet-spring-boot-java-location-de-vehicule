package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.mapper.ClientMapper;
import com.accenture.model.Client;
import com.accenture.repository.ClientDao;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService{

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public ClientResponseDto addClient(ClientRequestDto clientRequestDto){
        verify(clientRequestDto);
        Client saved = clientDao.save(clientMapper.toClient(clientRequestDto));
        return clientMapper.toClientResponseDto(saved);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientResponseDto> findAll() {
        List<Client> clients = clientDao.findAll();
        return clients.stream().map(clientMapper::toClientResponseDto).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public ClientResponseDto findById(int idClient) {
        Optional<Client> optionalClient = clientDao.findById(idClient);
        if (optionalClient.isEmpty())
            throw new EntityNotFoundException(messageSourceAccessor.getMessage("client.id.notfound"));
        return clientMapper.toClientResponseDto(optionalClient.get());
    }


    private void verify(ClientRequestDto clientRequestDto) {
        if (clientRequestDto == null)
            throw new ClientException(messageSourceAccessor.getMessage("client.null"));
        if (clientRequestDto.firstName() == null || clientRequestDto.firstName().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.firstname.nullorblank"));
        if (clientRequestDto.lastName() == null || clientRequestDto.lastName().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.lastname.nullorblank"));
        if (clientRequestDto.address() == null || clientRequestDto.address().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.address.nullorblank"));
    }
}
