package com.aghatec.ms_gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGatwayApplication.class, args);
	}

}
