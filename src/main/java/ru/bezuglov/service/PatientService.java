package ru.bezuglov.service;

import ru.bezuglov.dto.PatientNewDto;
import ru.bezuglov.dto.PatientDto;
import ru.bezuglov.dto.PatientShortDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    PatientShortDto save(PatientNewDto patientNewDto);

    PatientShortDto update(PatientNewDto patientUpdate, UUID uuid);

    void delete(UUID cartNumber);

    PatientDto findPatient(UUID cardNumber);

    List<PatientShortDto> findListPatients();
}
