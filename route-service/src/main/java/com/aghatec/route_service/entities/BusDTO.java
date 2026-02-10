package com.aghatec.route_service.entities;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BusDTO {
    private Long idBus;
    private String nomBus;
    private String immatricule;
    private int capacite;
    private Boolean enservice;
}
