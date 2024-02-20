package ru.bezuglov.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.Specialization;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

    private Long id;

    private UUID personalNumber;

    private FIODto fio;

    private Specialization specialization;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startWork;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endWork;
}
