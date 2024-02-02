package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.PatientShortDto;
import ru.bezuglov.prs.dto.TicketDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.service.TicketService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Override
    public TicketDto save(TicketFreeDto ticketFreeDto, UUID cartNumber) {
        return null;
    }

    @Override
    public TicketDto update(TicketFreeDto ticketUpdate, Long oldTicketId) {
        return null;
    }

    @Override
    public TicketFreeDto delete(Long id) {
        return null;
    }

    @Override
    public TicketDto findTicket(Long id) {
        return null;
    }

    @Override
    public List<TicketFreeDto> findListFreeTickets(String specialization) {
        return null;
    }

    @Override
    public List<TicketDto> findListBlockTickets(String specialization) {
        return null;
    }
}
