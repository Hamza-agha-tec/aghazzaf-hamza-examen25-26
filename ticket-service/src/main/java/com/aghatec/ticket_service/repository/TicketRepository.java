package com.aghatec.ticket_service.repository;
import com.aghatec.ticket_service.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}