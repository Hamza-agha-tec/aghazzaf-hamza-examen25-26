package com.aghatec.route_service.services;

import com.aghatec.route_service.BusOpenFeign;
import com.aghatec.route_service.entities.BusDTO;
import com.aghatec.route_service.entities.Route;
import com.aghatec.route_service.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService implements RouteInterface {

    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusOpenFeign busOpenFeign;

    @Override
    public List<Route> getRoutes(){
        List<Route> routes = routeRepository.findAll();
        routes.forEach(route -> {
            if(route.getIdBus() != null){
                BusDTO bus = busOpenFeign.findById(route.getIdBus());
                route.setBus(bus);
            }
        });
        return  routes;
    }

    @Override
    public Route getRoute(Long id){
        Route route =  routeRepository.findById(id).orElse(null);
        if(route.getIdBus() != null){
            BusDTO bus = busOpenFeign.findById(route.getIdBus());
            route.setBus(bus);
        }
        return route;
    }
    @Override
    public Route addRoute(Route route){
        Route newRoute = Route.builder()
                .nomBus(route.getNomBus())
                .villeDepart(route.getVilleDepart())
                .villeArrive(route.getVilleArrive())
                .build();
        if(route.getIdBus() != null){
            BusDTO bus = busOpenFeign.findById(route.getIdBus());
            if(bus != null){
                route.setBus(bus);
            } else {
                return  null;
            }
        } else {
            return null;
        }
        routeRepository.save(newRoute);
        return newRoute;
    }

    @Override
    public void removeRoute(Long id){
        routeRepository.deleteById(id);
    }
}