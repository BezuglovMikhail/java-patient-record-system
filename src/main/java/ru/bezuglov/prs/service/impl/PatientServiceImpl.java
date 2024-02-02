package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.PatientDto;
import ru.bezuglov.prs.dto.PatientNewDto;
import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.service.PatientService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
    @Override
    public PatientShortDto save(PatientNewDto patientNewDto) {
        return null;
    }

    @Override
    public PatientShortDto update(PatientNewDto patientUpdate, UUID cartNumber) {
        return null;
    }

    @Override
    public void delete(UUID cartNumber) {
    }

    @Override
    public PatientDto findPatient(UUID cardNumber) {
        return null;
    }

    @Override
    public List<PatientShortDto> findListPatients(Integer locationNumber) {
        return null;
    }
}
