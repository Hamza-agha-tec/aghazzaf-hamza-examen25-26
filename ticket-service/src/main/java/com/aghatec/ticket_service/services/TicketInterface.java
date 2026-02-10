package com.aghatec.ticket_service.services;


import com.aghatec.ticket_service.entities.Ticket;

import java.util.List;

public interface TicketInterface {
    public List<Ticket> getTickets();
    public Ticket getTicket(Long id);
    public Ticket addTicket(Ticket client);
    public void removeTicket(Long id);
}
