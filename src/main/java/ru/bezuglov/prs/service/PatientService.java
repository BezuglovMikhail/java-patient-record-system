package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.PatientDto;
import ru.bezuglov.prs.dto.PatientNewDto;
import ru.bezuglov.prs.dto.PatientShortDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    PatientShortDto save(PatientNewDto patientNewDto);

    PatientShortDto update(PatientNewDto patientUpdate, UUID uuid);

    void delete(UUID cartNumber);

    PatientDto findPatient(UUID cardNumber);

    List<PatientShortDto> findListPatients();
}
