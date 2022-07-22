package com.alimentatec.msemailnotification.controller;

import com.alimentatec.msemailnotification.dto.EmailInformationDTO;
import com.alimentatec.msemailnotification.service.INotificationEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Slf4j
@Validated
@RestController
@RequestMapping("/service/v1/send-notification-email")
public class NotificationEmailController {

    @Autowired
    private INotificationEmailService iNotificationEmailService;

    @Autowired
    private HashMap<String, Object> responseMap;

    @PostMapping
    public Mono<ResponseEntity<Object>> sendNotificationEmail(@RequestBody Mono<EmailInformationDTO> emailInformationDTOMono){
        return emailInformationDTOMono.map(emailInformationDTO -> {
            iNotificationEmailService.SendNotificationEmail(emailInformationDTO.getEmailToSend(),
                    emailInformationDTO.getSubject(),
                    emailInformationDTO.getBody());
            responseMap.put("code", "200");
            responseMap.put("message", "Success");
            return ResponseEntity.ok().body(responseMap);
        });
    }
}
