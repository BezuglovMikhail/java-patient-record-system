package ru.bezuglov.prs.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.prs.dto.TicketDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.service.TicketService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tickets")
@Slf4j
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TicketDto saveTicket(@Valid @RequestBody TicketFreeDto ticketFree, UUID cartNumber) {
        TicketDto addTicket = ticketService.save(ticketFree, cartNumber);
        log.info("Add ticket: {}", addTicket);
        return addTicket;
    }

    @GetMapping("/block")
    public List<TicketDto> getListBlockTickets(@RequestParam(required = false) String specialization) {
        List<TicketDto> ticket = ticketService.findListBlockTickets(specialization);
        log.info("Find listBlockTickets");
        return ticket;
    }

    @GetMapping("/free")
    public List<TicketFreeDto> getListFreeTickets(@RequestParam(required = false) String specialization) {
        List<TicketFreeDto> ticket = ticketService.findListFreeTickets(specialization);
        log.info("Find listBlockTickets");
        return ticket;
    }

    @GetMapping("/{ticketId}")
    public TicketDto getTicket(@PathVariable Long ticketId) {
        TicketDto ticket = ticketService.findTicket(ticketId);
        log.info("Find ticket whit id = {}", ticketId);
        return ticket;
    }

    @PatchMapping("/{ticketId}")
    public TicketDto updateTicket(@Valid @RequestBody TicketFreeDto ticketFree, @PathVariable Long oldTicketId) {
        TicketDto updateTicket = ticketService.update(ticketFree, oldTicketId);
        log.info("Update ticket whit id = {}", oldTicketId);
        return updateTicket;
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
        log.info("Ticket whit ticketId = {} delete.", ticketId);
    }
}
