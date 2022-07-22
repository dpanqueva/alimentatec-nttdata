package com.alimentatec.usernotify.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogsConfig {

    /**
     * Method for registry an object in the java memory
     * */
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
