package ru.bezuglov.prs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TicketFreeDto {

    private Long id;

    private DoctorShortDto doctor;

    //начало приема
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    //конец приема
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    private TicketStatus ticketStatus;
}
