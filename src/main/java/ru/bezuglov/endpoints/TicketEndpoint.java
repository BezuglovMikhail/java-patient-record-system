package ru.bezuglov.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.bezuglov.dto.TicketFreeDto;
import ru.bezuglov.gs_ws.*;
import ru.bezuglov.mapper.TicketMapperStatic;
import ru.bezuglov.service.TicketService;
import ru.bezuglov.until.TicketStatus;

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
        //TicketFree ticketFree = new TicketFree();

        TicketFree ticketFree = TicketMapperStatic.toTicketGetSoap(ticketService.findTicket(request.getTicketId()));

        //ticketFree = TicketMapper.toTicketFree(ticketFreeDto);
        //BeanUtils.copyProperties(TicketMapper.toTicketFree(ticketFreeDto), ticketFree);
        response.setTicketFree(ticketFree);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFreeTicketsRequest")
    @ResponsePayload
    public GetFreeTicketsResponse getFreeTickets(@RequestPayload GetFreeTicketsRequest request) {
        GetFreeTicketsResponse response = new GetFreeTicketsResponse();
        List<TicketFree> ticketFreeList = new ArrayList<>();
        //List<TicketFreeDto> ticketList = ticketService.findListFreeTickets(Specialization
           //     .fromString(request.getSpecialization()), request.getMin(), request.getDay());
        //List<TicketFreeDto> ticketList = ticketService.findListFreeTickets(request.getCountTickets(), request.getMin(),
             //   LocalDate.parse(request.getDayStart().toXMLFormat()));
        List<TicketFreeDto> ticketList = ticketService.findTicketsFreeList(TicketStatus.UNBLOCK);
       for (int i = 0; i < ticketList.size(); i++) {
            TicketFree ticketFree = new TicketFree();
            BeanUtils.copyProperties(TicketMapperStatic.toTicketFree(ticketList.get(i)), ticketFree);
            ticketFreeList.add(ticketFree);
        }


        response.getTicketFree().addAll(ticketFreeList);
        return response;
    }
}

