package ru.bezuglov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientNewDto {

    private FIODto fio;

    private LocalDate birthday;

    private String address;

    private Integer locationNumber;
}
