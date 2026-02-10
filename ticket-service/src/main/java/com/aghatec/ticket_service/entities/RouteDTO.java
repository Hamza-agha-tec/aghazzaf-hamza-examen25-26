package com.aghatec.ticket_service.entities;

import lombok.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor  @AllArgsConstructor @Builder
public class RouteDTO {
    private Long idRoute;
    private String nomBus;
    private String villeDepart;
    private String villeArrive;
    private Date dateDepart;
    private Date dateArrive;
}
