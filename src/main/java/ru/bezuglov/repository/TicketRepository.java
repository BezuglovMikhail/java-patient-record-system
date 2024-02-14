package ru.bezuglov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bezuglov.model.Ticket;
import ru.bezuglov.until.Specialization;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByDoctor_Id(Long doctorId);
    List<Ticket> findAllByDoctor_Specialization(Specialization specialization);
    List<Ticket> findAllByStatus(TicketStatus status);

    List<Ticket> findAllByPatient_Id(Long patientId);

    List<Ticket> findAllByPatient_CardNumber(UUID cardNumber);


    @Query("select t from Ticket t " +
           "WHERE t.doctor.id = ?1 " +
           "AND t.status = 'UNBLOCK' " +
           "AND cast (t.startTime as DATE) = ?2")
    List<Ticket> searchAllByDoctor_IdAndDay(Long doctorId, LocalDate day);
}
