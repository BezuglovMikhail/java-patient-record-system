package ru.bezuglov.service;

import ru.bezuglov.dto.DoctorDto;
import ru.bezuglov.dto.DoctorNewDto;
import ru.bezuglov.dto.DoctorShortDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    DoctorShortDto save(DoctorNewDto newDoctorDto);

    List<DoctorShortDto> findListDoctors();

    DoctorDto findDoctor(UUID personnelNumber);
    DoctorDto findDoctor(Long id);

    void delete(UUID personnelNumber);

    DoctorDto update(DoctorNewDto doctorUpdate, UUID personnelNumber);
}
