package ru.bezuglov.prs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fios")
public class FIO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Имя.
    private String firstName;
    //Фамилия
    private String lastName;
    //Отчество
    private String patronymic;

}
