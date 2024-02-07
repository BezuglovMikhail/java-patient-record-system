package ru.bezuglov.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.dto.PatientNewDto;
import ru.bezuglov.dto.PatientDto;
import ru.bezuglov.dto.PatientShortDto;
import ru.bezuglov.mapper.PatientMapper;
import ru.bezuglov.model.Patient;
import ru.bezuglov.repository.PatientRepository;
import ru.bezuglov.service.PatientService;

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
