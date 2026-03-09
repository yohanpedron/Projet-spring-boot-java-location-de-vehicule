package com.accenture.service;

import com.accenture.service.dto.CarRequestDto;
import com.accenture.service.dto.CarResponseDto;
import com.accenture.service.fake.FakeCarDao;
import com.accenture.service.fake.FakeCarMapper;
import com.accenture.utils.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.StaticMessageSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;

class CarServiceImplTest {

    private FakeCarDao fakeCarDao;
    private FakeCarMapper carMapper;
    private CarServiceImpl carService;

    @BeforeEach
    void setup(){
        fakeCarDao = new FakeCarDao();
        carMapper = new FakeCarMapper();

        carService = new CarServiceImpl(fakeCarDao,carMapper,messageAccessor());
    }

    @Nested
    @DisplayName("addCar")
    class AddCarTest{
        @Test
        @DisplayName("OK")
        void addCarOk(){
            CarRequestDto carRequestDto = new CarRequestDto(
                    "Audi",
                    "A3",
                    "Dark Grey",
                    "COMPACT",
                    68.5,
                    36500,
                    true,
                    false,
                    5,
                    "PETROL",
                     5,
                    "AUTOMATIC",
                    true,
                    3);
            CarResponseDto carResponseDto = carService.addCar(carRequestDto);

            assertEquals("Audi",carResponseDto.brand());
            assertEquals("A3",carResponseDto.model());
            assertEquals("Dark Grey",carResponseDto.color());
            assertEquals("COMPACT",carResponseDto.type());
            assertEquals(68.5,carResponseDto.dailyBaseRentalRate());
            assertEquals(36500,carResponseDto.kilometers());
            assertEquals(true,carResponseDto.active());
            assertEquals(false,carResponseDto.removedFromParc());
            assertEquals(5,carResponseDto.numberOfPlaces());
            assertEquals("PETROL",carResponseDto.fuelType());
            assertEquals(5,carResponseDto.numberOfDoors());
            assertEquals("AUTOMATIC",carResponseDto.transmission());
            assertEquals(true,carResponseDto.brand());
            assertEquals(3,carResponseDto.brand());
            assertEquals(1, fakeCarDao.store.size());
        }
    }

    private MessageSourceAccessor messageAccessor() {
        StaticMessageSource sms = new StaticMessageSource();
        sms.addMessage(Messages.CAR_ID_NOTFOUND, Locale.getDefault(),Messages.CAR_ID_NOTFOUND);
        sms.addMessage(Messages.CAR_COLOR_NULLORBLANK, Locale.getDefault(),Messages.CAR_COLOR_NULLORBLANK);
        sms.addMessage(Messages.CAR_BRAND_NULLORBLANK, Locale.getDefault(),Messages.CAR_BRAND_NULLORBLANK);
        sms.addMessage(Messages.CAR_KILOMETERS_NEGATIVE, Locale.getDefault(),Messages.CAR_KILOMETERS_NEGATIVE);
        sms.addMessage(Messages.CAR_FUELTYPE_NULLORBLANK, Locale.getDefault(),Messages.CAR_FUELTYPE_NULLORBLANK);
        sms.addMessage(Messages.CAR_MODEL_NULLORBLANK, Locale.getDefault(),Messages.CAR_MODEL_NULLORBLANK);
        sms.addMessage(Messages.CAR_NULL, Locale.getDefault(),Messages.CAR_NULL);
        sms.addMessage(Messages.CAR_DAILYBASERENTALRATE_NEGATIVE, Locale.getDefault(),Messages.CAR_DAILYBASERENTALRATE_NEGATIVE);
        sms.addMessage(Messages.CAR_TYPE_NULLORBLANK, Locale.getDefault(),Messages.CAR_TYPE_NULLORBLANK);
        sms.addMessage(Messages.CAR_TRANSMISSION_NULLORBLANK, Locale.getDefault(),Messages.CAR_TRANSMISSION_NULLORBLANK);
        sms.addMessage(Messages.CAR_NUMBEROFDOORS_INFERIORTO3, Locale.getDefault(),Messages.CAR_NUMBEROFDOORS_INFERIORTO3);
        sms.addMessage(Messages.CAR_NUMBEROFLUGGAGE_INFERIORTO1, Locale.getDefault(),Messages.CAR_NUMBEROFLUGGAGE_INFERIORTO1);
        sms.addMessage(Messages.CAR_NUMBEROFPLACES_INFERIORTO5, Locale.getDefault(),Messages.CAR_NUMBEROFPLACES_INFERIORTO5);
        return new MessageSourceAccessor(sms);
    }

}
