package ru.bezuglov.prs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.prs.model.Doctor;
import ru.bezuglov.prs.until.Specialization;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    List<Doctor> findAllBySpecialization(Specialization specialization);

}
