package ru.bezuglov.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bezuglov.dto.DoctorNewDto;
import ru.bezuglov.dto.DoctorShortDto;
import ru.bezuglov.dto.FIODto;
import ru.bezuglov.model.FIO;
import ru.bezuglov.service.DoctorService;
import ru.bezuglov.until.Specialization;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DoctorServiceImplTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    void save() {

        FIODto fio = new FIODto();
        fio.setFirstName("ioerjghp");
        fio.setLastName("duyfghoieuh");
        fio.setPatronymic("idyugboiey");

        DoctorNewDto doctorNewDto = new DoctorNewDto();
        doctorNewDto.setFio(fio);
        doctorNewDto.setSpecialization(Specialization.OCULIST);
        doctorNewDto.setStartWork(LocalTime.of(10, 00));
        doctorNewDto.setStartWork(LocalTime.of(20, 00));

        DoctorShortDto doctorShortDto = doctorService.save(doctorNewDto);

        DoctorShortDto checkDoctor = new DoctorShortDto();
        checkDoctor.setFio(fio);
        checkDoctor.setId(doctorShortDto.getId());
        checkDoctor.setSpecialization(Specialization.OCULIST);

        assertEquals(doctorShortDto.getId(), checkDoctor.getId());
    }

    @Test
    void findListDoctors() {
    }

    @Test
    void findDoctor() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}