package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.dto.TicketDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.service.TicketService;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Override
    public TicketDto save(TicketFreeDto ticketFreeDto, PatientShortDto patient) {
        return null;
    }

    @Override
    public TicketDto update(TicketFreeDto ticketUpdate, Long id) {
        return null;
    }

    @Override
    public TicketFreeDto delete(Long id) {
        return null;
    }

    @Override
    public TicketDto getTicket(Long id) {
        return null;
    }
}
