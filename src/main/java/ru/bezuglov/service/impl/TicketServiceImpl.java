package ru.bezuglov.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bezuglov.dto.TicketDto;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.mapper.TicketMapperStatic;
import ru.bezuglov.model.Doctor;
import ru.bezuglov.model.Patient;
import ru.bezuglov.model.Ticket;
import ru.bezuglov.repository.DoctorRepository;
import ru.bezuglov.repository.PatientRepository;
import ru.bezuglov.repository.TicketRepository;
import ru.bezuglov.service.TicketService;
import ru.bezuglov.until.TicketStatus;

import java.time.LocalDate;
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
    public TicketDto save(Long ticketFreeId, UUID cardNumber) {
        Patient patient = patientRepository.findByCardNumber(cardNumber);
        Ticket ticketBlock = TicketMapperStatic.toTicketNewBlockDto(ticketRepository.getReferenceById(ticketFreeId), patient);
        return TicketMapperStatic.toTicketDto(ticketRepository.save(ticketBlock));
    }

    @Override
    public TicketDto update(TicketFreeDto ticketUpdate, Long ticketId, UUID cardNumber) {
        Patient patient = patientRepository.findByCardNumber(cardNumber);
        Doctor doctor = doctorRepository.getReferenceById(ticketUpdate.getDoctor().getId());
        Ticket ticket = ticketRepository.getReferenceById(ticketId);
        return TicketMapperStatic.toTicketDto(ticketRepository.save(TicketMapperStatic.toUpdateTicket(ticketUpdate,
                ticket, doctor, patient)));
    }

    @Override
    public void delete(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticketRepository.deleteById(id);
        }
    }

    @Override
    public TicketDto findTicket(Long ticketId) {
        TicketDto ticket = TicketMapperStatic.toTicketDto(ticketRepository.getReferenceById(ticketId));
       return ticket;
    }

    @Override
    public TicketFreeDto findTicketFree(Long id) {
        return TicketMapperStatic.toTicketFreeDto(ticketRepository.getById(id));
    }

    private List<TicketFreeDto> saveFreeTicketsList(List<Ticket> ticketFreeList) {
        return TicketMapperStatic.toTicketFreeDtoList(ticketRepository.saveAll(ticketFreeList));
    }

    @Override
    public List<TicketFreeDto> findListFreeTickets(Integer countTickets, Integer min, LocalDate dayStart) {
        List<Doctor> doctorList = doctorRepository.findAll();

        List<Ticket> ticketFreeList = new ArrayList<>();

        for (Doctor doctor : doctorList) {
            List<TicketDto> ticketBlockList = TicketMapperStatic.toTicketBlockList(ticketRepository
                    .findAllByStatus(TicketStatus.BLOCK));
            List<TicketFreeDto> ticketFreeDtoList = TicketMapperStatic.toTicketFreeDtoList(ticketRepository
                    .findAllByStatus(TicketStatus.UNBLOCK));
            ticketFreeList.addAll(TicketMapperStatic.toTicketList(countTickets, min, dayStart,
                    doctor, ticketBlockList, ticketFreeDtoList));
        }
        return saveFreeTicketsList(ticketFreeList);
    }

    @Override
    public List<TicketDto> findTicketsBlockList(TicketStatus status) {
        List<TicketDto> ticketBlockList = TicketMapperStatic.toTicketBlockList(ticketRepository.findAllByStatus(status));
        return ticketBlockList;
    }

    @Override
    public List<TicketFreeDto> findTicketsFreeList(TicketStatus status) {
        List<TicketFreeDto> ticketFreeList = TicketMapperStatic.toTicketFreeDtoList(ticketRepository.findAllByStatus(status));
        return ticketFreeList;
    }

    @Override
    public List<TicketDto> findAllTicketsByPatientId(Long patientId) {
        List<TicketDto> ticketBlockList = TicketMapperStatic.toTicketBlockList(ticketRepository
                .findAllByPatient_Id(patientId));
        return ticketBlockList;
    }

    @Override
    public List<TicketDto> findAllTicketsByPatientCardNumber(UUID cardNumber) {
        List<TicketDto> ticketBlockList = TicketMapperStatic.toTicketBlockList(ticketRepository
                .findAllByPatient_CardNumber(cardNumber));
        return ticketBlockList;
    }

    @Override
    public List<TicketFreeDto> findFreeTicketsByDoctorIdForDay(Long doctorId, LocalDate day) {
        List<TicketFreeDto> ticketFreeList = TicketMapperStatic
               .toTicketFreeDtoList(ticketRepository
               .searchAllByDoctor_IdAndDay(doctorId, day));
        return ticketFreeList;

    }
}
