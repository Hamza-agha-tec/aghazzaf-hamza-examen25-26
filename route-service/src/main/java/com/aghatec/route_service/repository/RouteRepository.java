package com.aghatec.route_service.repository;

import com.aghatec.route_service.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {}