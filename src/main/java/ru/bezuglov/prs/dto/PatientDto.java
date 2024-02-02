package ru.bezuglov.prs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientDto {

    //private Long id;

    private UUID cartNumber;

    //private FIODto fio;

    private String firstName;

    private String lastName;

    private String patronymic;

    private LocalDate birthday;

    private String address;

    private Integer locationNumber;
}
