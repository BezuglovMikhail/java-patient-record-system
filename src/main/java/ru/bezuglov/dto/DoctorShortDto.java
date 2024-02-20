package ru.bezuglov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.Specialization;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DoctorShortDto {

    private FIODto fio;

    private UUID id;

    private Specialization specialization;

    @Override
    public String toString() {
        return "DoctorShortDto{" +
                "fio=" + fio +
                ", id=" + id +
                ", specialization=" + specialization +
                '}';
    }
}
