package ru.bezuglov.service;

import ru.bezuglov.dto.TicketDto;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TicketService {

    TicketDto save(Long ticketId, UUID cartNumber);

    TicketDto update(TicketFreeDto ticketUpdate, Long ticketId, UUID cardNumber);

    void delete(Long id);

    TicketDto findTicket(Long id);

    TicketFreeDto findTicketFree(Long id);

    List<TicketFreeDto> findListFreeTickets(Integer countTickets, Integer min, LocalDate dayStart);

    List<TicketDto> findTicketsBlockList(TicketStatus status);

    List<TicketFreeDto> findTicketsFreeList(TicketStatus status);

    List<TicketDto> findAllTicketsByPatientId(Long patientId);

    List<TicketDto> findAllTicketsByPatientCardNumber(UUID cardNumber);

    List<TicketFreeDto> findFreeTicketsByDoctorIdForDay(Long doctorId, LocalDate day);
}
