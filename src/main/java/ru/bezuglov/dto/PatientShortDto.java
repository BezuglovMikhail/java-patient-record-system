package ru.bezuglov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientShortDto {

    private Long id;

    private FIODto fio;

    private Integer locationNumber;

    @Override
    public String toString() {
        return "PatientShortDto{" +
                "id=" + id +
                ", fio=" + fio +
                ", locationNumber=" + locationNumber +
                '}';
    }
}
