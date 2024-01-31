package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.PatientDto;
import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.service.PatientService;

import java.util.UUID;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
    @Override
    public PatientShortDto save(PatientDto patientDto) {
        return null;
    }

    @Override
    public PatientShortDto update(PatientDto patientUpdate, UUID cartNumber) {
        return null;
    }

    @Override
    public void delete(UUID cartNumber) {

    }

    @Override
    public PatientShortDto findPatient(UUID cardNumber) {
        return null;
    }
}
