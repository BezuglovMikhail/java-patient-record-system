package ru.bezuglov.prs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class FIO {

    //Имя.
    private String firstName;
    //Фамилия
    private String lastName;
    //Отчество
    private String patronymic;

}
