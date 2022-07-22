package com.alimentatec.msconsumer.service;

import com.alimentatec.msconsumer.client.MsEmailNotificationClient;
import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.alimentatec.msconsumer.dto.RequestMsEmailInformationDTO;
import com.alimentatec.msconsumer.dto.ResponseMsEmailNotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class NotificationServiceImpl implements INotificationService{

    @Autowired
    private MsEmailNotificationClient msEmailNotificationClient;

    @Value("${email.subject}")
    private String subject;

    @Override
    public Mono<ResponseMsEmailNotificationDTO> sendNotification(NotificationDTO notificationDTO) {
        RequestMsEmailInformationDTO requestMsEmailInformationDTO = new RequestMsEmailInformationDTO(notificationDTO.getEmail(),subject, notificationDTO.getPayLoad());
        return msEmailNotificationClient.consumeMsEmailNotification(Mono.just(requestMsEmailInformationDTO));
    }
}
