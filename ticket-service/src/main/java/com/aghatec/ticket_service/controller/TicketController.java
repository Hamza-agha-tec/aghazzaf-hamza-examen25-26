package com.aghatec.ticket_service.controller;

import com.aghatec.ticket_service.entities.Ticket;
import com.aghatec.ticket_service.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService empruntService;

    @GetMapping("/tickets")
    public List<Ticket> getEmprunts(){
        return empruntService.getTickets();
    }
    @GetMapping("/tickets/{id}")
    public Ticket getEmprunt(@PathVariable Long id){
        return empruntService.getTicket(id);
    }
    @PostMapping("/tickets")
    public Ticket addEmprunt(@RequestBody Ticket ticket){
        return empruntService.addTicket(ticket);
    }
    @DeleteMapping("/tickets/{id}")
    public String removeTicket(@PathVariable Long id){
        empruntService.removeTicket(id);
        return  "Ticket deleted successfullt";
    }
//    @GetMapping("/emprunts/etudiant/{id}")
//    public List<Ticket> getEtudiantEmprunt(@PathVariable Long id){
//        return empruntService.getUserTickets(id);
//    }


}