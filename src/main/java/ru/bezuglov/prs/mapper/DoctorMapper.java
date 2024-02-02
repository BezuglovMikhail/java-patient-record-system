package ru.bezuglov.prs.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.DoctorNewDto;
import ru.bezuglov.prs.dto.DoctorShortDto;
import ru.bezuglov.prs.model.Doctor;

import java.util.UUID;

@UtilityClass
public class DoctorMapper {

    public DoctorDto toDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setFirstName(doctor.getFirstName());
        doctorDto.setLastName(doctor.getLastName());
        doctorDto.setPatronymic(doctor.getPatronymic());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setEndWork(doctor.getStartWork());
        doctorDto.setEndWork(doctor.getEndWork());
        return doctorDto;
    }

    public DoctorShortDto toDoctorShortDto(Doctor doctor) {
        DoctorShortDto doctorShortDto = new DoctorShortDto();
        doctorShortDto.setFirstName(doctor.getFirstName());
        doctorShortDto.setLastName(doctor.getLastName());
        doctorShortDto.setPatronymic(doctor.getPatronymic());
        doctorShortDto.setId(doctor.getId());
        doctorShortDto.setSpecialization(doctor.getSpecialization());
        return doctorShortDto;
    }

    public Doctor toDoctor(DoctorNewDto doctorNewDto) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(doctorNewDto.getFirstName());
        doctor.setLastName(doctorNewDto.getLastName());
        doctor.setPatronymic(doctorNewDto.getPatronymic());
        doctor.setSpecialization(doctorNewDto.getSpecialization());
        doctor.setStartWork(doctorNewDto.getStartWork());
        doctor.setEndWork(doctorNewDto.getEndWork());
        return doctor;
    }

}
