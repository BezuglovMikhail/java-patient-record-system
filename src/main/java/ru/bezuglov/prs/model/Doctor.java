package ru.bezuglov.prs.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    //ФИО
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fio_id", referencedColumnName = "id")
    //private FIO fio;

    private String firstName;

    private String lastName;

    private String patronymic;

    //Специализация врача
    //@Enumerated(EnumType.STRING)
    private String specialization;

    //начало рабочего дня
    private LocalTime startWork;
    //окончание рабочего дня
    private LocalTime endWork;
}
