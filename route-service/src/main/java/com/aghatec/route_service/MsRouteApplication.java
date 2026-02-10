package com.aghatec.route_service;

import com.aghatec.route_service.repository.RouteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRouteApplication.class, args);
	}

    @Bean
    CommandLineRunner init(RouteRepository routeRepository) {
        return args -> {
            System.out.println("Bonjour");

        };
    }

}
