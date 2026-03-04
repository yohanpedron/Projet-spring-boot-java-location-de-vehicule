package com.accenture.service.dto;

import com.accenture.model.Address;

import java.time.LocalDate;
import java.util.List;

public record AdminResponseDto(
        int id ,
        String firstName,
        String lastName,
        String function,
        String mail,
        String password
) {

}
