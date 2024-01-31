package ru.bezuglov.prs.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.Specialization;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class DoctorNewDto {

    private FIODto fio;

    @NotBlank
    private Specialization specialization;

    @Future
    private LocalTime startWork;

    @Future
    private LocalTime endWork;
}
