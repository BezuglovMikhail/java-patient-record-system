package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.PatientDto;
import ru.bezuglov.prs.dto.PatientShortDto;

import java.util.UUID;

public interface PatientService {

    PatientShortDto save(PatientDto patientDto);

    PatientShortDto update(PatientDto patientUpdate, UUID cartNumber);

    void delete(UUID cartNumber);

    PatientShortDto findPatient(UUID cardNumber);

}
