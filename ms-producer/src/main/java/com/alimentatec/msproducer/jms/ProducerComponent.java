package com.alimentatec.msproducer.jms;

import com.alimentatec.msproducer.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerComponent {

    @Autowired
    public JmsTemplate jmsTemplate;

    public void sendMessage(String notificationDTO){
        log.info("Sending notification: " + notificationDTO);
        this.jmsTemplate.convertAndSend("notification", notificationDTO);
    }
}
