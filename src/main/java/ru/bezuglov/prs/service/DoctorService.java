package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.DoctorNewDto;
import ru.bezuglov.prs.dto.DoctorShortDto;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    DoctorShortDto save(DoctorNewDto newDoctorDto);

    List<DoctorShortDto> findListDoctors(String specialization);

    DoctorDto findDoctor(UUID personnelNumber);

    void delete(UUID personnelNumber);

    DoctorDto update(DoctorNewDto doctorUpdate, UUID personnelNumber);
}
