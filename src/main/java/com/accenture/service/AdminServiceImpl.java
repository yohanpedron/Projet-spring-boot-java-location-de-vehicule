package com.accenture.service;

import com.accenture.model.Role;
import com.accenture.exception.AdminException;
import com.accenture.mapper.AdminMapper;
import com.accenture.model.Admin;
import com.accenture.repository.AdminDao;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao;
    private final AdminMapper adminMapper;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public AdminResponseDto addAdmin(AdminRequestDto adminRequestDto) throws AdminException {
        verify(adminRequestDto);
        Admin adminMapped = adminMapper.toAdmin(adminRequestDto);
        adminMapped.setRole(Role.ADMIN);
        Admin saved = adminDao.save(adminMapped);
        return adminMapper.toAdminResponseDto(saved);
    }

    public void verify(AdminRequestDto adminRequestDto){

    }
}
