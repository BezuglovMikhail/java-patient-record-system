package ru.bezuglov.prs.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.DoctorNewDto;
import ru.bezuglov.prs.dto.DoctorShortDto;
import ru.bezuglov.prs.model.Doctor;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DoctorMapper {

    public DoctorDto toDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setFio(FIOMapper.toFIODto(doctor.getFio()));
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setStartWork(doctor.getStartWork());
        doctorDto.setEndWork(doctor.getEndWork());
        return doctorDto;
    }

    public DoctorShortDto toDoctorShortDto(Doctor doctor) {
        DoctorShortDto doctorShortDto = new DoctorShortDto();
        doctorShortDto.setFio(FIOMapper.toFIODto(doctor.getFio()));
        doctorShortDto.setId(doctor.getId());
        doctorShortDto.setSpecialization(doctor.getSpecialization());
        return doctorShortDto;
    }

    public DoctorShortDto toDoctorShortDto(DoctorDto doctor) {
        DoctorShortDto doctorShortDto = new DoctorShortDto();
        doctorShortDto.setFio(doctor.getFio());
        doctorShortDto.setId(doctor.getId());
        doctorShortDto.setSpecialization(doctor.getSpecialization());
        return doctorShortDto;
    }

    public Doctor toDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setFio(FIOMapper.toFIO(doctorDto.getFio()));
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setStartWork(doctorDto.getStartWork());
        doctor.setEndWork(doctorDto.getEndWork());
        return doctor;
    }

    public Doctor toDoctorNew(DoctorNewDto doctorNewDto) {
        Doctor doctor = new Doctor();
        doctor.setFio(FIOMapper.toFIO(doctorNewDto.getFio()));
        doctor.setSpecialization(doctorNewDto.getSpecialization());
        doctor.setStartWork(doctorNewDto.getStartWork());
        doctor.setEndWork(doctorNewDto.getEndWork());
        return doctor;
    }

    public Doctor toUpdateDto(DoctorNewDto updateDoctor, Doctor oldDoctor) {
        Doctor newDoctor = new Doctor();
        newDoctor.setId(oldDoctor.getId());
        newDoctor.setFio(!updateDoctor.getFio().equals(oldDoctor.getFio())
                ? FIOMapper.toFIO(updateDoctor.getFio())
                : oldDoctor.getFio());
        newDoctor.setStartWork(updateDoctor.getStartWork() != null
                ? updateDoctor.getStartWork()
                : oldDoctor.getStartWork());
        newDoctor.setEndWork(updateDoctor.getEndWork() != null
                ? updateDoctor.getEndWork()
                : oldDoctor.getEndWork());
        newDoctor.setSpecialization(updateDoctor.getSpecialization() != null
                ? updateDoctor.getSpecialization()
                : oldDoctor.getSpecialization());
        return newDoctor;
    }

    public List<DoctorShortDto> mapToDoctorShortDto(Iterable<Doctor> doctors) {
        List<DoctorShortDto> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            result.add(toDoctorShortDto(doctor));
        }
        return result;
    }
    public List<DoctorDto> mapToDoctorDto(Iterable<Doctor> doctors) {
        List<DoctorDto> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            result.add(toDoctorDto(doctor));
        }
        return result;
    }
}
