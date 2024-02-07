package ru.bezuglov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.model.Ticket;
import ru.bezuglov.until.Specialization;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByDoctor_Id(UUID doctorId);
    List<Ticket> findAllByDoctor_Specialization(Specialization specialization);
}
