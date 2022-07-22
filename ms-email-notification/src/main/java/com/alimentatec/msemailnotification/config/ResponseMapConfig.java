package com.alimentatec.msemailnotification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ResponseMapConfig {

    @Bean
    public HashMap<String, Object> responseMap(){
        HashMap<String, Object> responseMap = new HashMap<>();
        return responseMap;
    }
}
