package ru.bezuglov.prs.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.prs.dto.TicketBlockDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.gs_ws.TicketFree;
import ru.bezuglov.prs.model.Doctor;
import ru.bezuglov.prs.model.Patient;
import ru.bezuglov.prs.model.Ticket;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.until.TicketStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TicketMapper {
    Long numberTicket = 0L;

    public Ticket toTicketNewBlockDto(TicketFreeDto ticketFreeDto, Doctor doctor, Patient patient) {
        Ticket ticketBlock = new Ticket();
        ticketBlock.setDoctor(doctor);
        ticketBlock.setPatient(patient);
        ticketBlock.setStartTime(ticketFreeDto.getStartTime());
        ticketBlock.setEndTime(ticketFreeDto.getEndTime());
        ticketBlock.setStatus(TicketStatus.BLOCK);
        return ticketBlock;
    }

    public List<TicketFreeDto> toTicketFreeDto(DoctorDto doctor, Long min, Long countDay,
                                               List<TicketBlockDto> ticketBlocks) {
        List<TicketFreeDto> ticketFreeList = new ArrayList<>();
        LocalDateTime nowDay = LocalDateTime.now();
        List<LocalDateTime> ticketBlockStartTimes = ticketBlocks.stream().map(e -> e.getStartTime())
                .collect(Collectors.toList());
        List<LocalDateTime> ticketBlockEndTimes = ticketBlocks.stream().map(e -> e.getEndTime())
                .collect(Collectors.toList());

        for (int i = 0; i < countDay; i++) {
            LocalDateTime start;
            if (i == 0) {
                start = nowDay.plusMinutes(5);
            } else {
                nowDay = nowDay.plusDays(1);
                start = LocalDateTime.of(nowDay.toLocalDate(), doctor.getStartWork());
            }
            for (LocalDateTime startTime = start; startTime.toLocalTime()
                    .isBefore(doctor.getEndWork());
                 startTime = startTime.plusMinutes(min)) {
                if (!ticketBlockStartTimes.contains(startTime) && !ticketBlockEndTimes
                        .contains(startTime.minusMinutes(1))) {
                    TicketFreeDto ticketFree = new TicketFreeDto();
                    ticketFree.setId(++numberTicket);
                    ticketFree.setTicketStatus(TicketStatus.UNBLOCK);
                    ticketFree.setDoctor(DoctorMapper.toDoctorShortDto(doctor));
                    ticketFree.setStartTime(startTime);
                    ticketFree.setEndTime(startTime.plusMinutes(min));
                    ticketFreeList.add(ticketFree);
                }
            }
        }
        return ticketFreeList;
    }

    public TicketBlockDto toTicketBlockDto(Ticket ticket) {
        TicketBlockDto ticketBlock = new TicketBlockDto();
        ticketBlock.setId(ticket.getId());
        ticketBlock.setDoctor(DoctorMapper.toDoctorDto(ticket.getDoctor()));
        ticketBlock.setPatient(PatientMapper.toPatientDto(ticket.getPatient()));
        ticketBlock.setTicketStatus(ticket.getStatus());
        ticketBlock.setStartTime(ticket.getStartTime());
        ticketBlock.setEndTime(ticket.getEndTime());
        return ticketBlock;
    }

    public TicketFree toTicketFree(TicketFreeDto ticketFreeDto) {
        TicketFree ticketFree = new TicketFree();
        ticketFree.setTicketId(ticketFreeDto.getId());
        ticketFree.setFirstName(ticketFreeDto.getDoctor().getFio().getFirstName());
        ticketFree.setLastName(ticketFreeDto.getDoctor().getFio().getLastName());
        ticketFree.setPatronymic(ticketFreeDto.getDoctor().getFio().getPatronymic());
        ticketFree.setDay(ticketFreeDto.getStartTime().toLocalDate().toString());
        ticketFree.setStartTime(ticketFreeDto.getStartTime().toLocalTime().toString());
        return ticketFree;
    }

    public Ticket toUpdateTicket(TicketFreeDto updateTicketTicket, Ticket oldTicket, Doctor doctor, Patient patient) {
        Ticket newTicket = new Ticket();
        newTicket.setId(oldTicket.getId());
        newTicket.setDoctor(doctor);
        newTicket.setPatient(patient);
        newTicket.setStartTime(!updateTicketTicket.getStartTime().equals(oldTicket.getStartTime())
                ? updateTicketTicket.getStartTime()
                : oldTicket.getStartTime());
        newTicket.setEndTime(!updateTicketTicket.getEndTime().equals(oldTicket.getEndTime())
                ? updateTicketTicket.getEndTime()
                : oldTicket.getEndTime());
        newTicket.setStatus(oldTicket.getStatus());
        return newTicket;
    }

    public List<TicketBlockDto> toTicketBlockList(List<Ticket> ticketList) {
        List<TicketBlockDto> ticketBlockList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ticketBlockList.add(toTicketBlockDto(ticket));
        }
        return ticketBlockList;
    }
}
