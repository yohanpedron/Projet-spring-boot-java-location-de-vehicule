package com.accenture.service.dto;

public record AdminRequestDto(
        String firstName,
        String lastName,
        String function,
        String mail,
        String password
) {
}
