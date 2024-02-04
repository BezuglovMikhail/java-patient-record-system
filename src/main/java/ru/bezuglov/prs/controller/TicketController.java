package ru.bezuglov.prs.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.prs.dto.TicketBlockDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.service.TicketService;
import ru.bezuglov.prs.until.Specialization;

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
    public TicketBlockDto saveTicket(@Valid @RequestBody TicketFreeDto ticketFree, @RequestParam UUID cartNumber) {
        TicketBlockDto addTicket = ticketService.save(ticketFree, cartNumber);
        log.info("Add ticket: {}", addTicket);
        return addTicket;
    }

    @GetMapping("/block")
    public List<TicketBlockDto> getListBlockTickets(@RequestParam(required = false) Specialization specialization) {
        List<TicketBlockDto> ticketBlockList = ticketService.findListBlockTickets(specialization);
        log.info("Find listBlockTickets");
        return ticketBlockList;
    }

    @GetMapping("/free")
    public List<TicketFreeDto> getListFreeTickets(@RequestParam(required = false) Specialization specialization,
                                                  @RequestParam(defaultValue = "15") Long min,
                                                  @RequestParam(defaultValue = "1") Long countDay) {
        List<TicketFreeDto> ticketFreeList = ticketService.findListFreeTickets(specialization, min, countDay);
        log.info("Find listFreeTickets");
        return ticketFreeList;
    }

    @GetMapping("/{ticketId}")
    public TicketBlockDto getTicket(@PathVariable Long ticketId) {
        TicketBlockDto ticket = ticketService.findTicket(ticketId);
        log.info("Find ticket whit id = {}", ticketId);
        return ticket;
    }

    @PatchMapping("/{ticketId}")
    public TicketBlockDto updateTicket(@Valid @RequestBody TicketFreeDto ticketFree, @PathVariable Long ticketId,
                                       @RequestParam UUID cartNumber) {
        TicketBlockDto updateTicket = ticketService.update(ticketFree, ticketId, cartNumber);
        log.info("Update ticket whit id = {}", ticketId);
        return updateTicket;
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
        log.info("Ticket whit ticketId = {} delete.", ticketId);
    }
}
