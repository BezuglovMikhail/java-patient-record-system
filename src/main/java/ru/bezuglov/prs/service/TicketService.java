package ru.bezuglov.prs.service;

import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.dto.TicketDto;
import ru.bezuglov.prs.dto.TicketFreeDto;

public interface TicketService {

    TicketDto save(TicketFreeDto ticketFreeDto, PatientShortDto patient);

    TicketDto update(TicketFreeDto ticketUpdate, Long id);

    TicketFreeDto delete(Long id);

    TicketDto getTicket(Long id);
}
