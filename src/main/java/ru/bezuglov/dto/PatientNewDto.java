package ru.bezuglov.dto;

import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientNewDto {

    private FIODto fio;

    @Past
    private LocalDate birthday;

    private String address;

    private Integer locationNumber;
}
