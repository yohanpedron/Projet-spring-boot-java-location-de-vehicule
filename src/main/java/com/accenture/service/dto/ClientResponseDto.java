package com.accenture.service.dto;

import java.util.List;

public record ClientResponseDto(int id ,String firstName, String lastName, String address, String mail, String password, String birthday, String registerDate, List<String> drivingLicenses, boolean deactivate) {
}
