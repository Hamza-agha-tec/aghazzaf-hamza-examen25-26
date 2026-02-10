package com.aghatec.route_service;

import com.aghatec.route_service.entities.BusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bus-service")
public interface BusOpenFeign {

    @GetMapping("/api/buses")
    List<BusDTO> findAll();

    @GetMapping("/api/buses/{id}")
    BusDTO findById(@PathVariable("id") Long id);
}
