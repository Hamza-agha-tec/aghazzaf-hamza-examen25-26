package com.aghatec.bus_service;

import com.aghatec.bus_service.entities.Bus;
import com.aghatec.bus_service.repository.BusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBusApplication.class, args);
	}

    @Bean
    CommandLineRunner start(BusRepository livreRepository) {
        return args -> {
            System.out.println("Bonjour");
            Bus bus1 = Bus.builder()
                    .nomBus("L1")
                    .immatricule("CD654125")
                    .capacite(100)
                    .enservice(true)
                    .build();

            Bus bus2 = Bus.builder()
                    .nomBus("L2")
                    .immatricule("ML123456")
                    .capacite(120)
                    .enservice(true)
                    .build();

            Bus bus3 = Bus.builder()
                    .nomBus("L3")
                    .immatricule("PC514285")
                    .capacite(80)
                    .enservice(true)
                    .build();

            livreRepository.save(bus1);
            livreRepository.save(bus2);
            livreRepository.save(bus3);
        };
    }

}