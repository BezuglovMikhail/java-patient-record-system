package ru.bezuglov.prs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.prs.model.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
