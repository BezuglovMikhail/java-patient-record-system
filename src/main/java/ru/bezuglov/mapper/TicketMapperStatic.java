package ru.bezuglov.mapper;

import lombok.experimental.UtilityClass;
import ru.bezuglov.dto.TicketDto;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.gs_ws.TicketFree;
import ru.bezuglov.model.Doctor;
import ru.bezuglov.model.Patient;
import ru.bezuglov.model.Ticket;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TicketMapperStatic {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Ticket toTicketNewBlockDto(Ticket ticketFree, Patient patient) {
        Ticket ticketBlock = ticketFree;
        ticketBlock.setPatient(patient);
        ticketBlock.setStatus(TicketStatus.BLOCK);
        return ticketBlock;
    }

    public List<Ticket> toTicketList(Integer countTickets, Integer min, LocalDate dayStart, Doctor doctor,
                                     List<TicketDto> ticketsBlock, List<TicketFreeDto> ticketsFree) {
        List<Ticket> ticketFreeList = new ArrayList<>();
        LocalDateTime nowDay = LocalDateTime.now();
        List<LocalDateTime> ticketStartTimes = ticketsBlock.stream().map(TicketDto::getStartTime)
                .collect(Collectors.toList());
        ticketStartTimes.addAll(ticketsFree.stream().map(TicketFreeDto::getStartTime).toList());
        List<LocalDateTime> ticketEndTimes = ticketsBlock.stream().map(TicketDto::getEndTime)
                .collect(Collectors.toList());
        ticketEndTimes.addAll(ticketsFree.stream().map(TicketFreeDto::getEndTime).toList());

        int count = 0;

        for (int i = 0; count < countTickets; i++) {
            LocalDateTime start;
            //LocalDateTime startCheck = LocalDateTime.of(dayStart, doctor.getEndWork());

            if (i == 0 && LocalDateTime.of(dayStart, doctor.getEndWork()).isAfter(LocalDateTime.now())
                    && LocalDateTime.of(dayStart, doctor.getStartWork()).isBefore(LocalDateTime.now())) {
                start = LocalDateTime.now().plusMinutes(10);
            } else if (i == 0 && LocalDateTime.now().isBefore(LocalDateTime.of(dayStart, doctor.getStartWork()))) {
                start = LocalDateTime.of(dayStart, doctor.getStartWork());
            } else {
                nowDay = nowDay.plusDays(1);
                start = LocalDateTime.of(nowDay.toLocalDate(), doctor.getStartWork());
            }
            for (LocalDateTime startTime = start;
                 startTime.toLocalTime().isBefore(doctor.getEndWork()) && count < countTickets;
                 startTime = startTime.plusMinutes(min)) {
                if (!ticketStartTimes.contains(startTime)
                        && startTime.toLocalTime().plusMinutes(min - 1).isBefore(doctor.getEndWork())
                        && !ticketEndTimes.contains(startTime.minusMinutes(1))) {
                    Ticket ticketFree = new Ticket();
                    ticketFree.setStatus(TicketStatus.UNBLOCK);
                    ticketFree.setDoctor(doctor);
                    ticketFree.setStartTime(startTime);
                    ticketFree.setEndTime(startTime.plusMinutes(min));
                    ticketFreeList.add(ticketFree);
                    count++;
                }
            }
        }
        return ticketFreeList;
    }


    public TicketDto toTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setDoctor(DoctorMapperStatic.toDoctorDto(ticket.getDoctor()));
        ticketDto.setPatient(PatientMapperStatic.toPatientDto(ticket.getPatient()));
        ticketDto.setTicketStatus(ticket.getStatus());
        ticketDto.setStartTime(ticket.getStartTime());
        ticketDto.setEndTime(ticket.getEndTime());
        return ticketDto;
    }

    public TicketFree toTicketGetSoap(TicketDto ticket) {
        TicketFree ticketFree = new TicketFree();
        ticketFree.setTicketId(ticket.getId());
        ticketFree.setFirstName(ticket.getDoctor().getFio().getFirstName());
        ticketFree.setLastName(ticket.getDoctor().getFio().getLastName());
        ticketFree.setPatronymic(ticket.getDoctor().getFio().getPatronymic());
        ticketFree.setStartTime(ticket.getStartTime().format(formatter).toString());
        ticketFree.setEndTime(ticket.getEndTime().format(formatter).toString());
        ticketFree.setTicketStatus(TicketStatus.BLOCK.name());
        return ticketFree;
    }

    /*public TicketBlock toTicketGetSoap(Ticket ticket) {
        TicketBlock ticketBlock = new TicketBlock();
        ticketBlock.setTicketId(ticket.getId());
        ticketBlock.setDoctorLastName(ticket.getDoctor().getFio().getLastName());
        ticketBlock.setPatientLastName(ticket.getPatient().getFio().getLastName());
        ticketBlock.setStartTime(ticket.getStartTime().format(formatter).toString());
        ticketBlock.setEndTime(ticket.getEndTime().format(formatter).toString());
        ticketBlock.setTicketStatus(TicketStatus.BLOCK.name());
        return ticketBlock;
    }*/

    public TicketFree toTicketFree(TicketFreeDto ticketFreeDto) {
        TicketFree ticketFree = new TicketFree();
        ticketFree.setTicketId(ticketFreeDto.getId());
        ticketFree.setFirstName(ticketFreeDto.getDoctor().getFio().getFirstName());
        ticketFree.setLastName(ticketFreeDto.getDoctor().getFio().getLastName());
        ticketFree.setPatronymic(ticketFreeDto.getDoctor().getFio().getPatronymic());
        ticketFree.setSpecialization(ticketFreeDto.getDoctor().getSpecialization().name());
        ticketFree.setStartTime(ticketFreeDto.getStartTime().format(formatter).toString());
        ticketFree.setEndTime(ticketFreeDto.getEndTime().format(formatter).toString());
        ticketFree.setTicketStatus(TicketStatus.UNBLOCK.name());
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

    public TicketFreeDto toTicketFreeDto(Ticket ticket) {
        TicketFreeDto ticketFreeDto = new TicketFreeDto();
        ticketFreeDto.setId(ticket.getId());
        ticketFreeDto.setDoctor(DoctorMapperStatic.toDoctorShortDto(ticket.getDoctor()));
        ticketFreeDto.setStartTime(ticket.getStartTime());
        ticketFreeDto.setEndTime(ticket.getEndTime());
        ticketFreeDto.setTicketStatus(ticket.getStatus());
        return ticketFreeDto;
    }

    public Ticket toTicket(TicketFreeDto ticketFree, Doctor doctor) {
        Ticket ticket = new Ticket();
        ticket.setDoctor(doctor);
        ticket.setStartTime(ticketFree.getStartTime());
        ticket.setEndTime(ticketFree.getEndTime());
        ticket.setStatus(ticketFree.getTicketStatus());
        return ticket;
    }

    public List<TicketFreeDto> toTicketFreeDtoList(List<Ticket> ticketList) {
        List<TicketFreeDto> ticketFreeList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ticketFreeList.add(TicketMapperStatic.toTicketFreeDto(ticket));
        }
        return ticketFreeList;
    }

    public List<TicketDto> toTicketBlockList(List<Ticket> ticketList) {
        List<TicketDto> ticketBlockList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ticketBlockList.add(toTicketDto(ticket));
        }
        return ticketBlockList;
    }
}
