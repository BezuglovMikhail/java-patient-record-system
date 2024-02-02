package ru.bezuglov.prs.dto;

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

   // private Long id;

    private UUID id;

    //private FIODto fio;

    private String firstName;

    private String lastName;

    private String patronymic;

    //private Specialization specialization;

    private String specialization;

    private LocalTime startWork;

    private LocalTime endWork;
}
