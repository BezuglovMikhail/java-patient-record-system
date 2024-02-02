package ru.bezuglov.prs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientShortDto {

    //private Long id;

    private UUID cartNumber;

    //private FIODto fio;

    private String firstName;

    private String lastName;

    private String patronymic;
}
