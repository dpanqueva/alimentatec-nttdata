package com.alimentatec.usernotify.controller;

import com.alimentatec.usernotify.client.MsProducerClient;
import com.alimentatec.usernotify.dto.RequestMsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/service/v1/user-notify")
@Slf4j
@Validated
public class NotificationController {

    @Autowired
    private MsProducerClient msProducerClient;

    @PostMapping
    public ResponseEntity<Object> sendPushAppNotification(@Valid @RequestBody RequestMsProducer requestMsProducer) {
        log.info("Petición POST realizada a ms-producer");
        return new ResponseEntity<>(msProducerClient.consumerMsProducer(requestMsProducer), HttpStatus.OK);
    }
}
