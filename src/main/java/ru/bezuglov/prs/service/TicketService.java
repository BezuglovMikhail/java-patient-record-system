package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.TicketBlockDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.until.Specialization;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    TicketBlockDto save(TicketFreeDto ticketFreeDto, UUID cartNumber);

    TicketBlockDto update(TicketFreeDto ticketUpdate, Long ticketId, UUID cardNumber);

    void delete(Long id);

    TicketBlockDto findTicket(Long id);

    List<TicketFreeDto> findListFreeTickets(Specialization specialization, Long min, Long countDay);

    List<TicketBlockDto> findListBlockTickets(Specialization specialization);
}
