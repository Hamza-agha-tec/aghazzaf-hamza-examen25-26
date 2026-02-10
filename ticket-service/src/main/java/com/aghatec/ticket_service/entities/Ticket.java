package com.aghatec.ticket_service.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String nomPassager;
    private LocalDate dateVoyyage;
    private double prix;

    private Long idBus;
    private Long idRoute;
    @Transient
    private BusDTO bus;
    @Transient
    private RouteDTO route;

}
