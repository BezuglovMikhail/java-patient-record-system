package ru.bezuglov.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.dto.DoctorDto;
import ru.bezuglov.dto.DoctorNewDto;
import ru.bezuglov.dto.DoctorShortDto;
import ru.bezuglov.service.DoctorService;

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
    public List<DoctorShortDto> getListDoctors() {
        List<DoctorShortDto> doctor = doctorService.findListDoctors();
        log.info("Find listDoctors");
        return doctor;
    }

    @GetMapping("/{uuid}")
    public DoctorDto getDoctor(@PathVariable("uuid") UUID uuid) {
        DoctorDto doctor = doctorService.findDoctor(uuid);
        log.info("Find doctor whit personnelNumber = {}", uuid);
        return doctor;
    }

    @PatchMapping("/{uuid}")
    public DoctorDto updateDoctor(@PathVariable("uuid") UUID uuid, @RequestBody DoctorNewDto doctorUpdate) {
        DoctorDto doctor = doctorService.update(doctorUpdate, uuid);
        log.info("Update doctor whit personnelNumber = {}", uuid);
        return doctor;
    }

    @DeleteMapping("/{uuid}")
    public void deleteDoctor(@PathVariable("uuid") UUID uuid) {
        doctorService.delete(uuid);
        log.info("Doctor whit personnelNumber = {} delete.", uuid);
    }
}
