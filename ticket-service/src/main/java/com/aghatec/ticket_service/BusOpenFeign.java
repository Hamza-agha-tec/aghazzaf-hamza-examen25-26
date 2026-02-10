package com.aghatec.ticket_service;
import com.aghatec.ticket_service.entities.BusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bus-service")
public interface BusOpenFeign {

    @GetMapping("/api/buses")
    List<BusDTO> findAll();

    @GetMapping("/api/buses/{id}")
    BusDTO findById(@PathVariable("id") Long id);
}
