package ru.bezuglov.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bezuglov.until.Specialization;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //табельный номер
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="personal_number", insertable = false, updatable = false, nullable = false)
    private UUID personalNumber;

    //ФИО
    @Embedded
    private FIO fio;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    //начало рабочего дня
    private LocalTime startWork;
    //окончание рабочего дня
    private LocalTime endWork;
}
