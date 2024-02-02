package ru.bezuglov.prs.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.DoctorNewDto;
import ru.bezuglov.prs.dto.DoctorShortDto;
import ru.bezuglov.prs.service.DoctorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/doctors")
@Slf4j
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public DoctorShortDto saveDoctor(@RequestBody DoctorNewDto doctor) {
        DoctorShortDto addDoctor = doctorService.save(doctor);
        log.info("Add doctor: {}", addDoctor);
        return addDoctor;
    }

    @GetMapping()
    public List<DoctorShortDto> getListDoctors(@RequestParam(required = false) String specialization) {
        List<DoctorShortDto> doctor = doctorService.findListDoctors(specialization);
        log.info("Find listDoctors");
        return doctor;
    }

    @GetMapping("/{personnelNumber}")
    public DoctorDto getDoctor(@PathVariable("personnelNumber") UUID personnelNumber) {
        DoctorDto doctor = doctorService.findDoctor(personnelNumber);
        log.info("Find doctor whit personnelNumber = {}", personnelNumber);
        return doctor;
    }

    @PatchMapping("/{personnelNumber}")
    public DoctorDto updateDoctor(@PathVariable("personnelNumber") UUID personnelNumber, DoctorNewDto doctorUpdate) {
        DoctorDto doctor = doctorService.update(doctorUpdate, personnelNumber);
        log.info("Update doctor whit personnelNumber = {}", personnelNumber);
        return doctor;
    }

    @DeleteMapping("/{personnelNumber}")
    public void deleteDoctor(@PathVariable("personnelNumber") UUID personnelNumber) {
        doctorService.delete(personnelNumber);
        log.info("Doctor whit personnelNumber = {} delete.", personnelNumber);
    }
}
