package ru.bezuglov.prs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.Specialization;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DoctorShortDto {

    //private Long id;

    private UUID personnelNumber;

    private FIODto fio;

    private Specialization specialization;
}
