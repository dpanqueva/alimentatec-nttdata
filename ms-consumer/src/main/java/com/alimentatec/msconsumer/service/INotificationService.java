package com.alimentatec.msconsumer.service;

import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.alimentatec.msconsumer.dto.RequestMsEmailInformationDTO;
import com.alimentatec.msconsumer.dto.ResponseMsEmailNotificationDTO;
import reactor.core.publisher.Mono;

public interface INotificationService {
    public Mono<ResponseMsEmailNotificationDTO> sendNotification(NotificationDTO notificationDTO);
}
