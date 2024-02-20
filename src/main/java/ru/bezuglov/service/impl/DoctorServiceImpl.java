package ru.bezuglov.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.dto.DoctorDto;
import ru.bezuglov.dto.DoctorNewDto;
import ru.bezuglov.dto.DoctorShortDto;
import ru.bezuglov.mapper.DoctorMapper;
import ru.bezuglov.model.Doctor;
import ru.bezuglov.repository.DoctorRepository;
import ru.bezuglov.service.DoctorService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorShortDto save(DoctorNewDto doctorNewDto) {
        return DoctorMapper.toDoctorShortDto(doctorRepository.save(DoctorMapper.toDoctorNew(doctorNewDto)));
    }

    @Override
    public List<DoctorShortDto> findListDoctors() {
        return DoctorMapper.mapToDoctorShortDto(doctorRepository.findAll());
    }

    @Override
    public DoctorDto findDoctor(UUID personalNumber) {
        return DoctorMapper.toDoctorDto(doctorRepository.findByPersonalNumber(personalNumber));
    }

    @Override
    public DoctorDto findDoctor(Long id) {
        return DoctorMapper.toDoctorDto(doctorRepository.getReferenceById(id));
    }

    @Override
    public void delete(UUID personalNumber) {
        Doctor deleteDoctor = doctorRepository.findByPersonalNumber(personalNumber);
        doctorRepository.deleteById(deleteDoctor.getId());
    }

    @Override
    public DoctorDto update(DoctorNewDto doctorUpdate, UUID personalNumber) {
        Doctor oldDoctor = doctorRepository.findByPersonalNumber(personalNumber);
        return DoctorMapper.toDoctorDto(doctorRepository.save(DoctorMapper.toUpdateDto(doctorUpdate, oldDoctor)));
    }
}
