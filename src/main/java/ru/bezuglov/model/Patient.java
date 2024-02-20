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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_number", insertable = false, updatable = false, nullable = false)
    private UUID cardNumber;

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
