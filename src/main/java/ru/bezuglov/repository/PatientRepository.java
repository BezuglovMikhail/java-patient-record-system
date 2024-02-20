package ru.bezuglov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.model.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByCardNumber(UUID cardNumber);
}
