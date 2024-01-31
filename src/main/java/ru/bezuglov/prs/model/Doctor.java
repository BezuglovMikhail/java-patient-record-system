package ru.bezuglov.prs.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.prs.until.Specialization;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    //табельный номер
    //private Integer personnelNumber;
    //табельный номер
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID personnelNumber;

    //ФИО
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fio_id", referencedColumnName = "id")
    private FIO fio;

    //Специализация врача
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    //начало рабочего дня
    private LocalTime startWork;
    //окончание рабочего дня
    private LocalTime endWork;
}
