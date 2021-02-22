/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.finalexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GeraldKazeemJyotiComp303Assign4MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeraldKazeemJyotiComp303Assign4MovieApplication.class, args);
		System.out.println("Movie micro-service is ready.....");
	}

}
