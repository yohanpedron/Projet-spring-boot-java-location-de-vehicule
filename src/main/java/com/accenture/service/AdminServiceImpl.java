package com.accenture.service;

import com.accenture.exception.ClientException;
import com.accenture.mapper.ClientMapper;
import com.accenture.model.Client;
import com.accenture.model.Role;
import com.accenture.exception.AdminException;
import com.accenture.mapper.AdminMapper;
import com.accenture.model.Admin;
import com.accenture.repository.AdminDao;
import com.accenture.repository.ClientDao;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;
import com.accenture.service.dto.ClientRequestDto;
import com.accenture.service.dto.ClientResponseDto;
import com.accenture.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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
    @Transactional(readOnly = true)
    public List<AdminResponseDto> findAllAdmins(){
        List<Admin> admins = adminDao.findAll();
        return admins.stream().map(adminMapper::toAdminResponseDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AdminResponseDto findAdminById(int idAdmin){
        Admin admin = adminDao.findById(idAdmin).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage(Messages.ADMIN_NOT_FOUND)));
        return adminMapper.toAdminResponseDto(admin);
    }

    @Override
    public void deleteAdmin(int idAdmin){
        if (!adminDao.existsById(idAdmin))
            throw new EntityNotFoundException(messageSourceAccessor.getMessage(Messages.ADMIN_NOT_FOUND));
        if (adminDao.findAll().size() <= 1)
            throw new AdminException(messageSourceAccessor.getMessage("admins.size.onlyone"));
        adminDao.deleteById(idAdmin);
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
        for(int compteur = 0;compteur < findAllAdmins().size();compteur++) {
            if (findAllAdmins().get(compteur).mail().equals(adminRequestDto.mail()))
                throw new AdminException(messageSourceAccessor.getMessage("admin.mail.alreadyexist"));
        }
        if (adminRequestDto.password() == null || adminRequestDto.password().isBlank())
            throw new AdminException(messageSourceAccessor.getMessage("admin.password.nullorblank"));
        if (!Pattern.matches("^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$",adminRequestDto.password()))
            throw new AdminException(messageSourceAccessor.getMessage("admin.password.wrongformat"));
    }
}
