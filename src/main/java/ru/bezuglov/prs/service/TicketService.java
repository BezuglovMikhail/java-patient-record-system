package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.TicketDto;
import ru.bezuglov.prs.dto.TicketFreeDto;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    TicketDto save(TicketFreeDto ticketFreeDto, UUID cartNumber);

    TicketDto update(TicketFreeDto ticketUpdate, Long oldTicketId);

    TicketFreeDto delete(Long id);

    TicketDto findTicket(Long id);

    List<TicketFreeDto> findListFreeTickets(String specialization);

    List<TicketDto> findListBlockTickets(String specialization);
}
