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

    //private FIONewDto fio;
    private String firstName;

    private String lastName;

    private String patronymic;

    //@NotBlank
    //private Specialization specialization;
    private String specialization;

    private LocalTime startWork;

    private LocalTime endWork;
}
