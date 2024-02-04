package ru.bezuglov.prs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.prs.dto.DoctorDto;
import ru.bezuglov.prs.dto.TicketBlockDto;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.mapper.DoctorMapper;
import ru.bezuglov.prs.mapper.TicketMapper;
import ru.bezuglov.prs.model.Doctor;
import ru.bezuglov.prs.model.Patient;
import ru.bezuglov.prs.model.Ticket;
import ru.bezuglov.prs.repository.DoctorRepository;
import ru.bezuglov.prs.repository.PatientRepository;
import ru.bezuglov.prs.repository.TicketRepository;
import ru.bezuglov.prs.service.TicketService;
import ru.bezuglov.prs.until.Specialization;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public TicketBlockDto save(TicketFreeDto ticketFreeDto, UUID cartNumber) {
        Optional<Patient> patient = patientRepository.findById(cartNumber);
        Optional<Doctor> doctor = doctorRepository.findById(ticketFreeDto.getDoctor().getId());
        Ticket ticketBlock = new Ticket();
            ticketBlock = TicketMapper.toTicketNewBlockDto(ticketFreeDto, doctor.get(), patient.get());

        return TicketMapper.toTicketBlockDto(ticketRepository.save(ticketBlock));
    }

    @Override
    public TicketBlockDto update(TicketFreeDto ticketUpdate, Long ticketId, UUID cardNumber) {
        Optional<Patient> patient = patientRepository.findById(cardNumber);
        Optional<Doctor> doctor = doctorRepository.findById(ticketUpdate.getDoctor().getId());
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        return TicketMapper.toTicketBlockDto(ticketRepository.save(TicketMapper.toUpdateTicket(ticketUpdate,
                ticket.get(), doctor.get(), patient.get())));
    }

    @Override
    public void delete(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticketRepository.deleteById(id);
        }
    }

    @Override
    public TicketBlockDto findTicket(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return TicketMapper.toTicketBlockDto(ticket.get());
    }

    @Override
    public List<TicketFreeDto> findListFreeTickets(Specialization specialization, Long min, Long countDay) {
        List<DoctorDto> doctorList = new ArrayList<>();

        if (specialization != null) {
            doctorList = DoctorMapper.mapToDoctorDto(doctorRepository.findAllBySpecialization(specialization));
        } else {
            doctorList = DoctorMapper.mapToDoctorDto(doctorRepository.findAll());
        }

        List<TicketFreeDto> ticketFreeList = new ArrayList<>();

        for (DoctorDto doctorDto : doctorList) {
            List<TicketBlockDto> ticketBlockList = TicketMapper
                    .toTicketBlockList(ticketRepository.findAll());
            ticketFreeList.addAll(TicketMapper.toTicketFreeDto(doctorDto, min, countDay, ticketBlockList));
        }
        return ticketFreeList;
    }

    @Override
    public List<TicketBlockDto> findListBlockTickets(Specialization specialization) {
        List<TicketBlockDto> ticketBlockList = new ArrayList<>();
        if (specialization != null) {
            ticketBlockList = TicketMapper
                    .toTicketBlockList(ticketRepository.findAllByDoctor_Specialization(specialization));
        } else {
            ticketBlockList = TicketMapper.toTicketBlockList(ticketRepository.findAll());
        }
        return ticketBlockList;
    }
}
