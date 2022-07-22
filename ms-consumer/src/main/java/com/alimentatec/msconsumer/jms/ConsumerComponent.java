package com.alimentatec.msconsumer.jms;

import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.alimentatec.msconsumer.dto.ResponseMsEmailNotificationDTO;
import com.alimentatec.msconsumer.service.INotificationService;
import com.alimentatec.msconsumer.util.IUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ConsumerComponent {

    @Autowired
    private IUtil iUtil;

    @Autowired
    private INotificationService iNotificationService;

    @JmsListener(destination = "notification")
    public void receiveMessage(String jsonStringValue){
        log.info("Consumer-> "+jsonStringValue);
        Mono<NotificationDTO> notificationDTOMono = iUtil.convertMonoStringToMonoObjectNotificationDTO(jsonStringValue);
        Mono<ResponseMsEmailNotificationDTO> responseMsEmailNotificationDTOMono = notificationDTOMono.flatMap(notificationDTO ->iNotificationService.sendNotification(notificationDTO));
        responseMsEmailNotificationDTOMono.subscribe(info -> log.info(info.getMessage()));
    }
}
