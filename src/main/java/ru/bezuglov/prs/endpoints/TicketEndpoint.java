package ru.bezuglov.prs.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.bezuglov.prs.dto.TicketFreeDto;
import ru.bezuglov.prs.gs_ws.GetTicketsByLastNameAndSpecializationRequest;
import ru.bezuglov.prs.gs_ws.GetTicketsByLastNameAndSpecializationResponse;
import ru.bezuglov.prs.gs_ws.TicketFree;
import ru.bezuglov.prs.mapper.TicketMapper;
import ru.bezuglov.prs.service.TicketService;
import ru.bezuglov.prs.until.Specialization;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TicketEndpoint {
private static final String NAMESPACE_URI = "http://www.bezuglov.ru/ticket-ws";
    @Autowired
    private TicketService ticketService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTicketsByLastNameAndSpecializationRequest")
    @ResponsePayload
    public GetTicketsByLastNameAndSpecializationResponse getTicketsByLastNameAndSpecialization(@RequestPayload GetTicketsByLastNameAndSpecializationRequest request) {
        GetTicketsByLastNameAndSpecializationResponse response = new GetTicketsByLastNameAndSpecializationResponse();
        List<TicketFree> ticketFreeList = new ArrayList<>();
        List<TicketFreeDto> ticketList = ticketService.findListFreeTickets(Specialization
                .fromString(request.getSpecialization()), request.getMin(), request.getDay());
        for (int i = 0; i < ticketList.size(); i++) {
            TicketFree ticketFree = new TicketFree();
            BeanUtils.copyProperties(TicketMapper.toTicketFree(ticketList.get(i)), ticketFree);
            ticketFreeList.add(ticketFree);
        }
        response.getTicketFree().addAll(ticketFreeList);
        return response;
    }
}

