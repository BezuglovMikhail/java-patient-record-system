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
    public List<PatientShortDto> getListPatients(@RequestParam(required = false) Integer locationNumber) {
        List<PatientShortDto> patient = patientService.findListPatients(locationNumber);
        log.info("Find listPatients");
        return patient;
    }

    @GetMapping("/{cartNumber}")
    public PatientDto getPatient(@PathVariable("personnelNumber") UUID cartNumber) {
        PatientDto patient = patientService.findPatient(cartNumber);
        log.info("Find patient whit cartNumber = {}", cartNumber);
        return patient;
    }

    @PatchMapping("/{cartNumber}")
    public PatientShortDto updatePatient(@PathVariable("personnelNumber") UUID cartNumber, PatientNewDto patientUpdate) {
        PatientShortDto patient = patientService.update(patientUpdate, cartNumber);
        log.info("Update patient whit cartNumber = {}", cartNumber);
        return patient;
    }

    @DeleteMapping("/{cartNumber}")
    public void deletePatient(@PathVariable("personnelNumber") UUID cartNumber) {
        patientService.delete(cartNumber);
        log.info("patient whit cartNumber = {} delete.", cartNumber);
    }
}
