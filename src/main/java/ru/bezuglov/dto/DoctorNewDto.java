package ru.bezuglov.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.Specialization;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class DoctorNewDto {

    private FIODto fio;

    @NotBlank
    private Specialization specialization;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startWork;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime endWork;
}
