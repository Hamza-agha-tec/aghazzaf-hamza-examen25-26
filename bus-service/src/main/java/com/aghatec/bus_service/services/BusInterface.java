package com.aghatec.bus_service.services;


import com.aghatec.bus_service.entities.Bus;

import java.util.List;
import java.util.Optional;

public interface BusInterface {
    public List<Bus> getBuses();
    public Optional<Bus> getBus(Long id);
    public Bus addBus(Bus client);
    public void removeBus(Long id);
}
