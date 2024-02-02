package ru.bezuglov.prs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.Specialization;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

    private UUID id;

    private FIODto fio;

    private Specialization specialization;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startWork;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endWork;
}
