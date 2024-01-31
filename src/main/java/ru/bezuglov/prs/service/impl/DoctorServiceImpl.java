package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.DoctorNewDto;
import ru.bezuglov.prs.dto.DoctorShortDto;
import ru.bezuglov.prs.repository.DoctorRepository;
import ru.bezuglov.prs.repository.FIORepository;
import ru.bezuglov.prs.service.DoctorService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private FIORepository fioRepository;


    @Override
    public DoctorShortDto save(DoctorNewDto doctorNewDto) {
        return null;
    }

    @Override
    public List<DoctorShortDto> findDoctors() {
        return null;
    }

    @Override
    public DoctorDto findDoctor(UUID personnelNumber) {
        return null;
    }

    @Override
    public void deleteDoctor(UUID personnelNumber) {

    }

    @Override
    public DoctorDto update(DoctorNewDto doctorUpdate, UUID personnelNumber) {
        return null;
    }
}
