package com.accenture.service;

import com.accenture.exception.AdminException;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;

import java.util.List;

public interface AdminService {

    AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) throws AdminException;

    List<AdminResponseDto> findAllAdmins();

}
