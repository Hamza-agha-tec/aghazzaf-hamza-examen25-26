package com.aghatec.route_service.controller;

import com.aghatec.route_service.entities.Route;
import com.aghatec.route_service.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;


    @GetMapping("/routes")
    public List<Route> getRoutes(){
        return routeService.getRoutes();
    }

    @GetMapping("/routes/{id}")
    public Route getRoute(@PathVariable Long id) {
        return routeService.getRoute(id);
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route route){
        return  routeService.addRoute(route);
    }

    @DeleteMapping("/routes/{id}")
    public String removeRoute(@PathVariable Long id){
        routeService.removeRoute(id);
        return "Route removed Successfully";
    }
}
