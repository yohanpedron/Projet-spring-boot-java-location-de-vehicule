package com.accenture.mapper;

import com.accenture.model.Client;
import com.accenture.service.dto.AddressDto;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import com.accenture.service.dto.ClientResponseForAdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface ClientMapper {

    Client toClient(ClientRequestDto clientRequestDto);
    ClientResponseDto toClientResponseDto(Client client);
    ClientResponseForAdminDto toClientResponseForAdminDto(Client client);

}
