package ru.bezuglov.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    //ФИО
    @Embedded
    private FIO fio;

    @Past
    private LocalDate birthday;

    //адрес
    private String address;

    //номер участка
    private Integer locationNumber;
}
