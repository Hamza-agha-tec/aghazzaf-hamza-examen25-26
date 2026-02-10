package com.aghatec.bus_service.web;


import com.aghatec.bus_service.entities.Bus;
import com.aghatec.bus_service.services.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping("/buses")
    public List<Bus> getBuses(){
        return busService.getBuses();
    }

    @GetMapping("/buses/{id}")
    public Optional<Bus> getBus(@PathVariable Long id){
        return busService.getBus(id);
    }

    @PostMapping("/buses")
    public Bus addBus(@RequestBody Bus bus){
        return busService.addBus(bus);
    }

    @DeleteMapping("/buses/{id}")
    public String removeBus(@PathVariable Long id){
        busService.removeBus(id);
        return  "Bus removed successfully";
    }
}
