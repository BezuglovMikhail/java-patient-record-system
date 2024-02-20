package ru.bezuglov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.Specialization;

@Getter
@Setter
@NoArgsConstructor
public class DoctorShortDto {

    private Long id;

    private FIODto fio;

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
