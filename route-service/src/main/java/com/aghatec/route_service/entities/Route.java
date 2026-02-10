package com.aghatec.route_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoute;
    private String nomBus;
    private String villeDepart;
    private String villeArrive;

    private Long idBus;
    @Transient
    private BusDTO bus;
}
