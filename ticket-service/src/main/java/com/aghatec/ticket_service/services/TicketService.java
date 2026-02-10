package com.aghatec.ticket_service.services;

import com.aghatec.ticket_service.BusOpenFeign;
import com.aghatec.ticket_service.RouteOpenFeign;
import com.aghatec.ticket_service.entities.BusDTO;
import com.aghatec.ticket_service.entities.Ticket;
import com.aghatec.ticket_service.entities.RouteDTO;
import com.aghatec.ticket_service.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;
    private final BusOpenFeign busOpenFeign;
    private final RouteOpenFeign routeOpenFeign;
    @Override
    public List<Ticket> getTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        tickets.forEach(ticket -> {
            if(ticket.getIdBus() != null){
                BusDTO bus = busOpenFeign.findById(ticket.getIdBus());
                ticket.setBus(bus);
            }

            if(ticket.getIdRoute() !=  null){
                RouteDTO route = routeOpenFeign.findById(ticket.getIdRoute());
                ticket.setRoute(route);
            }
        } );
        return tickets;
    }

    @Override
    public Ticket getTicket(Long id){
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if(ticket.getIdBus() != null){
            BusDTO bus = busOpenFeign.findById(ticket.getIdBus());
            ticket.setBus(bus);
        }
        if(ticket.getIdRoute() != null){
            RouteDTO route = routeOpenFeign.findById(ticket.getIdRoute());
            ticket.setRoute(route);
        }
        return ticket;
    }

    @Override
    public Ticket addTicket(Ticket ticket2){
        Ticket ticket = Ticket.builder()
                .idBus(ticket2.getIdBus())
                .idRoute(ticket2.getIdRoute())
                .nomPassager(ticket2.getNomPassager())
                .dateVoyyage(ticket2.getDateVoyyage())
                .prix(ticket2.getPrix())
                .build();
        if(ticket2.getIdBus() != null){
            BusDTO bus = busOpenFeign.findById(ticket2.getIdBus());
            if(bus != null){
                ticket.setBus(bus);
            } else {
                return  null;
            }
        } else {
            return null;
        }
        if(ticket2.getIdRoute() != null){
            RouteDTO route = routeOpenFeign.findById(ticket2.getIdRoute());
            if(route != null){
                ticket.setRoute(route);
            } else {
                return null;
            }
        } else {
            return null;
        }
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public void removeTicket(Long id){
        ticketRepository.deleteById(id);
    }

//    @Override
//    public List<Ticket> getUserTickets(Long id){
//        List<Ticket> tickets = ticketRepository.find(id);
//        tickets.forEach(emprunt -> {
//            if(emprunt.getIdLivre() != null){
//                RouteDTO produit = livreOpenFeign.findById(emprunt.getIdLivre());
//                emprunt.setLivre(produit);
//            }
//
//            if(emprunt.getIdEtudiant() !=  null){
//                BusDTO client = busOpenFeign.findById(emprunt.getIdEtudiant());
//                emprunt.setEtudiant(client);
//            }
//        } );
//
//        return tickets;
//    }
}