package com.nttdata.alimentatec.alimentatec.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlimentatecGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlimentatecGatewayApplication.class, args);
	}

}
