package com.aghatec.ticket_service;

import com.aghatec.ticket_service.entities.Ticket;
import com.aghatec.ticket_service.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTicketApplication.class, args);
	}

    @Bean
    CommandLineRunner start(TicketRepository empruntRepository) {
        return args -> {
            System.out.println("Bonjour");
        };
    }

}
