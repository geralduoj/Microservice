package com.assign.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GeraldKazeemJyotiComp303Assign4TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeraldKazeemJyotiComp303Assign4TicketApplication.class, args);
		System.out.println("ticket service running");
	}

}
