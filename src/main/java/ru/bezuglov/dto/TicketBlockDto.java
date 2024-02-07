package ru.bezuglov.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TicketBlockDto {

    private Long id;

    private DoctorDto doctor;

    private PatientDto patient;

    //начало приема
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    //конец приема
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    private TicketStatus ticketStatus;
}
