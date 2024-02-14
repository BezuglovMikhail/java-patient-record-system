package ru.bezuglov.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bezuglov.dto.TicketDto;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.service.TicketService;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tickets")
@Slf4j
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/{ticketFreeId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TicketDto saveTicket(@PathVariable Long ticketFreeId, @RequestParam UUID cartNumber) {
        TicketDto addTicket = ticketService.save(ticketFreeId, cartNumber);
        log.info("Add ticket: {}", addTicket);
        return addTicket;
    }

    @GetMapping("/block")
    public List<TicketDto> getListBlockTickets() {
        List<TicketDto> ticketBlockList = ticketService.findTicketsBlockList(TicketStatus.BLOCK);
        log.info("Find listBlockTickets, size = {}", ticketBlockList.size());
        return ticketBlockList;
    }

    @GetMapping("/block/{patientId}")
    public List<TicketDto> getListBlockTicketsByPatientId(@PathVariable Long patientId) {
        List<TicketDto> ticketBlockList = ticketService.findAllTicketsByPatientId(patientId);
        log.info("Find listBlockTickets, size = {}", ticketBlockList.size());
        return ticketBlockList;
    }

    @GetMapping("/block/cardNumber")
    public List<TicketDto> getListBlockTicketsByPatientCardNumber(@RequestParam UUID cardNumber) {
        List<TicketDto> ticketBlockList = ticketService.findAllTicketsByPatientCardNumber(cardNumber);
        log.info("Find listBlockTickets, size = {}", ticketBlockList.size());
        return ticketBlockList;
    }

    @GetMapping("/free")
    public List<TicketFreeDto> getListFreeTickets() {
        List<TicketFreeDto> ticketFreeList = ticketService.findTicketsFreeList(TicketStatus.UNBLOCK);
        log.info("Find listFreeTickets, size = {}", ticketFreeList.size());
        return ticketFreeList;
    }

    @GetMapping("/free/{doctorId}")
    public List<TicketFreeDto> getListFreeTicketsByDoctorId(@PathVariable Long doctorId,
                                                            @RequestParam LocalDate day) {
        List<TicketFreeDto> ticketFreeList = ticketService.findFreeTicketsByDoctorIdForDay(doctorId, day);
        log.info("Find listBlockTickets, size = {}", ticketFreeList.size());
        return ticketFreeList;
    }

    @PostMapping("/free")
    public List<TicketFreeDto> getListFreeTickets(@RequestParam(defaultValue = "10") Integer countTickets,
                                                  @RequestParam(defaultValue = "15") Integer min,
                                                  @RequestParam LocalDate dayStart) {
        List<TicketFreeDto> ticketFreeList = ticketService.findListFreeTickets(countTickets, min, dayStart);
        log.info("Find listFreeTickets");
        return ticketFreeList;
    }

    @GetMapping("/{ticketId}")
    public TicketFreeDto getTicketFree(@PathVariable Long ticketId) {
        TicketFreeDto ticket = ticketService.findTicketFree(ticketId);
        log.info("Find ticket whit id = {}", ticketId);
        return ticket;
    }

    @PatchMapping("/{ticketId}")
    public TicketDto updateTicket(@Valid @RequestBody TicketFreeDto ticketFree, @PathVariable Long ticketId,
                                       @RequestParam UUID cartNumber) {
        TicketDto updateTicket = ticketService.update(ticketFree, ticketId, cartNumber);
        log.info("Update ticket whit id = {}", ticketId);
        return updateTicket;
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        ticketService.delete(ticketId);
        log.info("Ticket whit ticketId = {} delete.", ticketId);
    }
}
