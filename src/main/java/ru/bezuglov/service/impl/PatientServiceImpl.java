package ru.bezuglov.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.dto.PatientNewDto;
import ru.bezuglov.dto.PatientDto;
import ru.bezuglov.dto.PatientShortDto;
import ru.bezuglov.mapper.PatientMapperStatic;
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
        return PatientMapperStatic.toPatientShortDto(patientRepository.save(PatientMapperStatic.toPatient(patientNewDto)));
    }

    @Override
    public PatientShortDto update(PatientNewDto patientUpdate, UUID uuid) {
        Patient oldPatient = patientRepository.findByCardNumber(uuid);
        return PatientMapperStatic.toPatientShortDto(patientRepository.save(PatientMapperStatic
                .toUpdatePatientDto(patientUpdate, oldPatient)));
    }

    @Override
    public void delete(UUID cartNumber) {
        Patient deletePatient = patientRepository.findByCardNumber(cartNumber);
        patientRepository.getReferenceById(deletePatient.getId());
        patientRepository.deleteById(deletePatient.getId());
    }

    @Override
    public PatientDto findPatient(UUID cardNumber) {
        return PatientMapperStatic.toPatientDto(patientRepository.findByCardNumber(cardNumber));
    }

    @Override
    public PatientDto findPatient(Long id) {
        return PatientMapperStatic.toPatientDto(patientRepository.getReferenceById(id));
    }

    @Override
    public List<PatientShortDto> findListPatients() {
            return PatientMapperStatic.mapToPatientDto(patientRepository.findAll());
    }
}
