package ru.bezuglov.prs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bezuglov.prs.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
