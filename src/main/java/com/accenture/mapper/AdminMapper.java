package com.accenture.mapper;

import com.accenture.model.Admin;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toAdmin(AdminRequestDto adminRequestDto);
    AdminResponseDto toAdminResponseDto(Admin admin);
}
