package com.nttdata.ofertassecundarias.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.nttdata.ofertassecundarias.model.client.ws.SecondaryOfferClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.nttdata.ofertassecundarias.model.client.dto");
        return marshaller;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    @Primary
    public SecondaryOfferClient clientSoap(Jaxb2Marshaller marshaller) {
        SecondaryOfferClient client = new SecondaryOfferClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
