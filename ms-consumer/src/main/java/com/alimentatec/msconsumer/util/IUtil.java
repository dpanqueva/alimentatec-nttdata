package com.alimentatec.msconsumer.util;

import com.alimentatec.msconsumer.dto.NotificationDTO;
import reactor.core.publisher.Mono;

public interface IUtil {
    Mono<NotificationDTO> convertMonoStringToMonoObjectNotificationDTO(String jsonStringValue);
}
