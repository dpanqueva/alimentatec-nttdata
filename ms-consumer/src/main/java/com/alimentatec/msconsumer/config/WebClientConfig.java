package com.alimentatec.msconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${ms.email.notification.url}")
    private String url;

    @Bean
    public WebClient.Builder webClient(){
        return WebClient.builder().baseUrl(url);
    }
}
