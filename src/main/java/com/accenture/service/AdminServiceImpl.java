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

import java.util.List;

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

    @Override
    public List<AdminResponseDto> findAllAdmins(){
        List<Admin> radios = adminDao.findAll();
        return radios.stream()
                .map(adminMapper::toAdminResponseDto)
                .toList();
    }

    public void verify(AdminRequestDto adminRequestDto){
        if (adminRequestDto == null)
            throw new AdminException(messageSourceAccessor.getMessage("admin.null"));
        if (adminRequestDto.firstName() == null || adminRequestDto.firstName().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.firstname.nullorblank"));
        if (adminRequestDto.lastName() == null || adminRequestDto.lastName().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.lastname.nullorblank"));
        if (adminRequestDto.function() == null || adminRequestDto.function().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.function.nullorblank"));
        if (adminRequestDto.mail() == null || adminRequestDto.mail().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.mail.nullorblank"));

        if (adminRequestDto.password() == null || adminRequestDto.password().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.password.nullorblank"));
    }
}
