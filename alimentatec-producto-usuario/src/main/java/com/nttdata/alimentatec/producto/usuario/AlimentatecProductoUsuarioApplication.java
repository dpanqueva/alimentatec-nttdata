package com.nttdata.alimentatec.producto.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class AlimentatecProductoUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlimentatecProductoUsuarioApplication.class, args);
	}

}
