package ru.bezuglov.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.bezuglov.dto.TicketDto;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.gs_ws.*;
import ru.bezuglov.mapper.TicketMapper;
import ru.bezuglov.service.TicketService;
import ru.bezuglov.until.Specialization;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TicketEndpoint {
private static final String NAMESPACE_URI = "http://www.bezuglov.ru/ticket-ws";
    @Autowired
    private TicketService ticketService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTicketByIdRequest")
    @ResponsePayload
    public GetTicketByIdResponse getTicketById(@RequestPayload GetTicketByIdRequest request) {
        GetTicketByIdResponse response = new GetTicketByIdResponse();
        TicketBlock ticketBlock = new TicketBlock();

        TicketDto ticketBlockDto = ticketService.findTicket(request.getTicketId());

        ticketBlock = TicketMapper.toTicketBlock(ticketBlockDto);
        response.setTicketBlock(ticketBlock);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTicketsByLastNameAndSpecializationRequest")
    @ResponsePayload
    public GetTicketsByLastNameAndSpecializationResponse getTicketsByLastNameAndSpecialization(@RequestPayload GetTicketsByLastNameAndSpecializationRequest request) {
        GetTicketsByLastNameAndSpecializationResponse response = new GetTicketsByLastNameAndSpecializationResponse();
        List<TicketFree> ticketFreeList = new ArrayList<>();
        //List<TicketFreeDto> ticketList = ticketService.findListFreeTickets(Specialization
           //     .fromString(request.getSpecialization()), request.getMin(), request.getDay());
       // List<TicketFreeDto> ticketList = ticketService.findListFreeTickets(request.getSpecialization()), request.getMin(), request.getDay());

      //  for (int i = 0; i < ticketList.size(); i++) {
        //    TicketFree ticketFree = new TicketFree();
        //    BeanUtils.copyProperties(TicketMapper.toTicketFree(ticketList.get(i)), ticketFree);
        //    ticketFreeList.add(ticketFree);
       // }
        response.getTicketFree().addAll(ticketFreeList);
        return response;
    }
}

