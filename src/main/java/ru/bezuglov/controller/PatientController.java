package ru.bezuglov.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.dto.PatientDto;
import ru.bezuglov.dto.PatientNewDto;
import ru.bezuglov.dto.PatientShortDto;
import ru.bezuglov.service.PatientService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/patients")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PatientShortDto savePatient(@Valid @RequestBody PatientNewDto patient) {
        PatientShortDto addPatient = patientService.save(patient);
        log.info("Add patient: {}", addPatient);
        return addPatient;
    }

    @GetMapping()
    public List<PatientShortDto> getListPatients() {
        List<PatientShortDto> patient = patientService.findListPatients();
        log.info("Find listPatients");
        return patient;
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable("id") Long id) {
        PatientDto patient = patientService.findPatient(id);
        log.info("Find patient whit cartNumber = {}", id);
        return patient;
    }

    @PatchMapping("/{id}")
    public PatientShortDto updatePatient(@PathVariable("id") UUID id, @Valid @RequestBody PatientNewDto patientUpdate) {
        PatientShortDto patient = patientService.update(patientUpdate, id);
        log.info("Update patient whit cartNumber = {}", id);
        return patient;
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") UUID id) {
        patientService.delete(id);
        log.info("patient whit cartNumber = {} delete.", id);
    }
}
