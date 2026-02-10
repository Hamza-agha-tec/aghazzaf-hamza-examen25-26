package com.aghatec.ticket_service;

import com.aghatec.ticket_service.entities.RouteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "route-service")
public interface RouteOpenFeign {

    @GetMapping("/api/routes")
    List<RouteDTO> findAll();

    @GetMapping("/api/routes/{id}")
    RouteDTO findById(@PathVariable("id") Long id);

}