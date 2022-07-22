package com.nttdata.alimentatec.alimentatec.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AlimentatecEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlimentatecEurekaServerApplication.class, args);
	}

}
