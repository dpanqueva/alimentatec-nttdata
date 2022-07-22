package com.nttdata.alimentatec.usuarios.asignar.productos.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
//@LoadBalancerClient(name = "restCaller", configuration = CustomLoadBalancerConfiguration.class)
public class WebClientConfig {

    // @Bean
    //@LoadBalanced
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }

    // @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}