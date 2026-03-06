package com.accenture.service;

import com.accenture.exception.CarException;
import com.accenture.exception.MotorcycleException;
import com.accenture.mapper.CarMapper;
import com.accenture.mapper.MotorcycleMapper;
import com.accenture.model.Car;
import com.accenture.model.Motorcycle;
import com.accenture.repository.CarDao;
import com.accenture.repository.MotorcycleDao;
import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.dto.MotorcycleRequestDto;
import com.accenture.service.dto.MotorcycleResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleDao motorcycleDao;
    private final MotorcycleMapper motorcycleMapper;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public MotorcycleResponseDto addMotorcycle(@Valid MotorcycleRequestDto motorcycleRequestDto) throws MotorcycleException {
        verifyMotorcycle(motorcycleRequestDto);
        Motorcycle motorcycleMapped = motorcycleMapper.toMotorcycle(motorcycleRequestDto);
        motorcycleMapped.setDriverLicencesAvailable(List.of("A1","A2","A"));
        Motorcycle saved = motorcycleDao.save(motorcycleMapped);
        return motorcycleMapper.toMotorcycleResponseDto(saved);
    }

    @Override
    public List<MotorcycleResponseDto> findAllMotorcycles(){
        List<Motorcycle> motorcycles = motorcycleDao.findAll();
        return motorcycles.stream().map(motorcycleMapper::toMotorcycleResponseDto).toList();
    }

    @Override
    public MotorcycleResponseDto findMotorcycleById(int idMotorcycle){
        Motorcycle motorcycle = motorcycleDao.findById(idMotorcycle).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage("motorcycle.id.notfound")));
        return motorcycleMapper.toMotorcycleResponseDto(motorcycle);
    }

    @Override
    public void deleteMotorcycle(int idMotorcycle){
        if (!motorcycleDao.existsById(idMotorcycle))
            throw new EntityNotFoundException(messageSourceAccessor.getMessage(""));
        motorcycleDao.deleteById(idMotorcycle);
    }

    @Override
    public MotorcycleResponseDto patchMotorcycle(int idMotorcycle, MotorcycleRequestDto motorcycleRequestDto){
        Motorcycle motorcycle = motorcycleDao.findById(idMotorcycle).orElseThrow(() -> new EntityNotFoundException(messageSourceAccessor.getMessage("motorcycle.id.notfound")));
        Motorcycle saved = motorcycleDao.save(motorcycle);
        return motorcycleMapper.toMotorcycleResponseDto(saved);
    }

    private void verifyMotorcycle(MotorcycleRequestDto motorcycleRequestDto) {
        if (motorcycleRequestDto == null)
            throw new CarException(messageSourceAccessor.getMessage("motorcycle.null"));
    }
}
