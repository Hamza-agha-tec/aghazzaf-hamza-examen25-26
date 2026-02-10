package com.aghatec.bus_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBus;
    private String nomBus;
    private String immatricule;
    private int capacite;
    private Boolean enservice;
}
