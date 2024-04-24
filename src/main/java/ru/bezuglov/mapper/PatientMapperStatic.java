package ru.bezuglov.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.dto.PatientDto;
import ru.bezuglov.dto.PatientNewDto;
import ru.bezuglov.dto.PatientShortDto;
import ru.bezuglov.model.Patient;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PatientMapperStatic {

    public PatientDto toPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setCardNumber(patient.getCardNumber());
        patientDto.setFio(FIOMapperStatic.toFIODto(patient.getFio()));
        patientDto.setBirthday(patient.getBirthday());
        patientDto.setAddress(patient.getAddress());
        patientDto.setLocationNumber(patient.getLocationNumber());
        return patientDto;
    }

    public PatientShortDto toPatientShortDto(Patient patient) {
        PatientShortDto patientShortDto = new PatientShortDto();
        patientShortDto.setId(patient.getId());
        patientShortDto.setFio(FIOMapperStatic.toFIODto(patient.getFio()));
        patientShortDto.setLocationNumber(patient.getLocationNumber());
        return patientShortDto;
    }

    public Patient toPatient(PatientNewDto patientNewDto) {
        Patient patient = new Patient();
        patient.setFio(FIOMapperStatic.toFIO(patientNewDto.getFio()));
        patient.setBirthday(patientNewDto.getBirthday());
        patient.setAddress(patientNewDto.getAddress());
        patient.setLocationNumber(patientNewDto.getLocationNumber());
        return patient;
    }

    public Patient toUpdatePatientDto(PatientNewDto updatePatient, Patient oldPatient) {
        Patient newPatient = new Patient();
        newPatient.setId(oldPatient.getId());
        newPatient.setFio(!updatePatient.getFio().equals(oldPatient.getFio())
                ? FIOMapperStatic.toFIO(updatePatient.getFio())
                : oldPatient.getFio());
        newPatient.setBirthday(updatePatient.getBirthday() != null
                ? updatePatient.getBirthday()
                : oldPatient.getBirthday());
        newPatient.setAddress(updatePatient.getAddress() != null
                ? updatePatient.getAddress()
                : oldPatient.getAddress());
        newPatient.setLocationNumber(updatePatient.getLocationNumber() != null
                ? updatePatient.getLocationNumber()
                : oldPatient.getLocationNumber());
        return newPatient;
    }

    public List<PatientShortDto> mapToPatientDto(Iterable<Patient> patients) {
        List<PatientShortDto> result = new ArrayList<>();
        for (Patient patient : patients) {
            result.add(toPatientShortDto(patient));
        }
        return result;
    }
}
