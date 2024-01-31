package ru.bezuglov.prs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.prs.model.Doctor;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
