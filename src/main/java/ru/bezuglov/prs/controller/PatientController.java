package ru.bezuglov.prs.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.prs.dto.*;
import ru.bezuglov.prs.service.PatientService;

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
    public PatientDto getPatient(@PathVariable("id") UUID id) {
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
