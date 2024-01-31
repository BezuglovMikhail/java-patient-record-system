package ru.bezuglov.prs.model;

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
@Table(name = "patient")
public class Patient {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    //номер карты
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cartNumber;
    //ФИО
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fio_id", referencedColumnName = "id")
    private FIO fio;

    @Past
    private LocalDate birthday;

    //адрес
    private String address;

    //номер участка
    private Integer parcelNumber;
}
