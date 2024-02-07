package ru.bezuglov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PatientShortDto {

    private FIODto fio;

    private UUID id;

    private Integer locationNumber;
}
