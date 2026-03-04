package com.accenture.service;

import com.accenture.model.Admin;
import com.accenture.model.Role;
import com.accenture.exception.ClientException;
import com.accenture.mapper.AddressMapper;
import com.accenture.mapper.ClientMapper;
import com.accenture.model.Address;
import com.accenture.model.Client;
import com.accenture.repository.ClientDao;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService{

    private static final String CLIENT_NOT_FOUND = "client.id.notfound";

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public ClientResponseDto addClient(ClientRequestDto clientRequestDto) throws ClientException {
        verify(clientRequestDto);
        Client clientMapped = clientMapper.toClient(clientRequestDto);
        Address addressMapped = addressMapper.toEntity(clientRequestDto.addressDto());
        clientMapped.setAddress(addressMapped);
        clientMapped.setRole(Role.CLIENT);
        clientMapped.setRegisterDate(LocalDate.now(ZoneId.of("Europe/Paris")));
        Client saved = clientDao.save(clientMapped);
        return clientMapper.toClientResponseDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseDto> findAllClients() {
        List<Client> clients = clientDao.findAll();
        return clients.stream().map(clientMapper::toClientResponseDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto findClientById(int idClient){
        Client client = clientDao.findById(idClient).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage(CLIENT_NOT_FOUND)));
        return clientMapper.toClientResponseDto(client);
    }

    @Override
    public void deleteClient(int idClient){
        if (!clientDao.existsById(idClient))
            throw new EntityNotFoundException(messageSourceAccessor.getMessage(CLIENT_NOT_FOUND));
        clientDao.deleteById(idClient);
    }

    private void verify(ClientRequestDto clientRequestDto) {
        if (clientRequestDto == null)
            throw new ClientException(messageSourceAccessor.getMessage("client.null"));
        if (clientRequestDto.firstName() == null || clientRequestDto.firstName().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.firstname.nullorblank"));
        if (clientRequestDto.lastName() == null || clientRequestDto.lastName().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.lastname.nullorblank"));
        if (clientRequestDto.addressDto() == null)
            throw new ClientException(messageSourceAccessor.getMessage("client.address.null"));
        if (clientRequestDto.addressDto().street() == null || clientRequestDto.addressDto().street().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.address.street.nullorblank"));
        if (clientRequestDto.addressDto().postalCode() == null || clientRequestDto.addressDto().postalCode().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.address.postalcode.nullorblank"));
        if (!Pattern.matches("^[0-9]{5}$",clientRequestDto.addressDto().postalCode()))
            throw new ClientException(messageSourceAccessor.getMessage("client.address.postalcode.wrongformat"));
        if (clientRequestDto.addressDto().city() == null || clientRequestDto.addressDto().city().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.address.city.nullorblank"));
        if (clientRequestDto.mail() == null || clientRequestDto.mail().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.mail.nullorblank"));
        for(int compteur = 0;compteur < findAllClients().size();compteur++) {
            if (findAllClients().get(compteur).mail().equals(clientRequestDto.mail()))
                throw new ClientException(messageSourceAccessor.getMessage("client.mail.alreadyexist"));
        }
        if (clientRequestDto.password() == null || clientRequestDto.password().isBlank())
            throw new ClientException(messageSourceAccessor.getMessage("client.password.nullorblank"));
        if (!Pattern.matches("^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$",clientRequestDto.password()))
            throw new ClientException(messageSourceAccessor.getMessage("client.password.wrongformat"));
        if (clientRequestDto.birthday() == null)
            throw new ClientException(messageSourceAccessor.getMessage("client.birthday.null"));
        if (LocalDate.now(ZoneId.of("Europe/Paris")).minusYears(18).isBefore(clientRequestDto.birthday()))
            throw new ClientException(messageSourceAccessor.getMessage("client.birthday.ageunder18"));
        if (clientRequestDto.drivingLicenses() == null)
            throw new ClientException(messageSourceAccessor.getMessage("client.drivinglicences.null"));
        for(int compteur = 0;compteur < clientRequestDto.drivingLicenses().size();compteur++) {
            if (clientRequestDto.drivingLicenses().get(compteur) == null || clientRequestDto.drivingLicenses().get(compteur).isBlank())
                throw new ClientException(messageSourceAccessor.getMessage("client.oneofdrivinglicences.nullorblank"));
        }
    }
}
