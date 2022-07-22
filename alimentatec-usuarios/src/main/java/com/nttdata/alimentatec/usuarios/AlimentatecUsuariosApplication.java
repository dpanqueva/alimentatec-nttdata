package com.nttdata.alimentatec.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlimentatecUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlimentatecUsuariosApplication.class, args);
    }

}
