package ru.bezuglov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.model.Doctor;
import ru.bezuglov.until.Specialization;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllBySpecialization(Specialization specialization);

    Doctor findByPersonalNumber(UUID personalNumber);
}
