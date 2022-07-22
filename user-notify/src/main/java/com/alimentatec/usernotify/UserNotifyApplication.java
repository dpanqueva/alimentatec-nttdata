package com.alimentatec.usernotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserNotifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserNotifyApplication.class, args);
    }

}
