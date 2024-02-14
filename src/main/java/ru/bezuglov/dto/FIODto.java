package ru.bezuglov.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FIODto {

    @Pattern(regexp = "[а-яА-Я]")
    private String firstName;

    @Pattern(regexp = "[а-яА-Я]")
    private String lastName;

    @Pattern(regexp = "[а-яА-Я]")
    private String patronymic;

    @Override
    public String toString() {
        return "FIODto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
