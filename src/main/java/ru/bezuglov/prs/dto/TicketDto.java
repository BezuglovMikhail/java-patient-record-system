package ru.bezuglov.prs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto {

    private Long id;

    private DoctorShortDto doctor;

    private PatientShortDto patient;

    //начало приема
    private LocalDateTime startTime;

    //конец приема
    private LocalDateTime endTime;

    private TicketStatus ticketStatus;
}
