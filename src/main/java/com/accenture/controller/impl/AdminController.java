package com.accenture.controller.impl;

import com.accenture.controller.AdminApi;
import com.accenture.service.AdminService;
import com.accenture.service.dto.AdminRequestDto;
import com.accenture.service.dto.AdminResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController implements AdminApi {

    private final AdminService adminService;

    @Override
    public ResponseEntity<Void> addAdmin(@Valid AdminRequestDto adminRequestDto) {
        AdminResponseDto adminResponseDto = adminService.addAdmin(adminRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(adminResponseDto).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<List<AdminResponseDto>> admins(){
        return ResponseEntity.ok(adminService.findAllAdmins());
    }

    @Override
    public ResponseEntity<AdminResponseDto> admin(int idAdmin){ return ResponseEntity.ok(adminService.findAdminById(idAdmin)); }

    @Override
    public ResponseEntity<Void> deleteAdmin(int idAdmin) {
        adminService.deleteAdmin(idAdmin);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<AdminResponseDto> patchAdmin(int idAdmin, AdminRequestDto adminRequestDto) {
        AdminResponseDto adminResponseDto = adminService.modifyPartiallyAdmin(idAdmin, adminRequestDto);
        return ResponseEntity.ok(adminResponseDto);
    }
}
