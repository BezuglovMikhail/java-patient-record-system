package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.PatientDto;
import ru.bezuglov.prs.dto.PatientNewDto;
import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.mapper.PatientMapper;
import ru.bezuglov.prs.model.Patient;
import ru.bezuglov.prs.repository.PatientRepository;
import ru.bezuglov.prs.service.PatientService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientShortDto save(PatientNewDto patientNewDto) {
        return PatientMapper.toPatientShortDto(patientRepository.save(PatientMapper.toPatient(patientNewDto)));
    }

    @Override
    public PatientShortDto update(PatientNewDto patientUpdate, UUID uuid) {
        Patient oldPatient = patientRepository.getReferenceById(uuid);
        return PatientMapper.toPatientShortDto(patientRepository.save(PatientMapper
                .toUpdatePatientDto(patientUpdate, oldPatient)));
    }

    @Override
    public void delete(UUID cartNumber) {
        patientRepository.deleteById(cartNumber);
    }

    @Override
    public PatientDto findPatient(UUID cardNumber) {
        return PatientMapper.toPatientDto(patientRepository.getReferenceById(cardNumber));
    }

    @Override
    public List<PatientShortDto> findListPatients() {
            return PatientMapper.mapToPatientDto(patientRepository.findAll());
    }
}
