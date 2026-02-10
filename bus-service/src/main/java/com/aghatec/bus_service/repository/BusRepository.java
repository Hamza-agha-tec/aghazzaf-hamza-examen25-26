package com.aghatec.bus_service.repository;

import com.aghatec.bus_service.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> { }