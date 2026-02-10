package com.aghatec.route_service.services;

import com.aghatec.route_service.entities.Route;
import java.util.List;
import java.util.Optional;

public interface RouteInterface {
    public List<Route> getRoutes();
    public Route getRoute(Long id);
    public Route addRoute(Route client);
    public void removeRoute(Long id);
}
