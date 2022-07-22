package com.alimentatec.msproducer.controller;

import com.alimentatec.msproducer.dto.NotificationDTO;
import com.alimentatec.msproducer.jms.ProducerComponent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/service/v1/send-notification")
public class NotificationController {

    @Autowired
    private ProducerComponent producerComponent;

    @PostMapping
    public Mono<ResponseEntity<Object>> sendNotification(@Valid @RequestBody Mono<NotificationDTO> notificationDTOMono){

        return notificationDTOMono
                .map(notificationDTO -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStringValue = "";
                    try {
                        jsonStringValue = objectMapper.writeValueAsString(notificationDTO);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    producerComponent.sendMessage(jsonStringValue);
                    return ResponseEntity.accepted().body("");
                });
    }

}
