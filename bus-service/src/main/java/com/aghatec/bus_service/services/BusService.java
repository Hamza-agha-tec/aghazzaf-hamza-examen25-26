package com.aghatec.bus_service.services;

import com.aghatec.bus_service.entities.Bus;
import com.aghatec.bus_service.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService implements BusInterface {

    @Autowired
    BusRepository busRepository;

    @Override
    public List<Bus> getBuses(){
        return busRepository.findAll();
    }

    @Override
    public Optional<Bus> getBus(Long id){
        return busRepository.findById(id);
    }
    @Override
    public Bus addBus(Bus busReq){
        Bus bus = Bus.builder()
                .immatricule(busReq.getImmatricule())
                .capacite(busReq.getCapacite())
                .nomBus(busReq.getNomBus())
                .enservice(busReq.getEnservice())
                .build();
        busRepository.save(bus);
        return bus;
    }

    @Override
    public void removeBus(Long id){
        busRepository.deleteById(id);
    }
}