package com.alimentatec.msconsumer.util;

import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UtilImpl implements IUtil{
    @SneakyThrows
    @Override
    public Mono<NotificationDTO> convertMonoStringToMonoObjectNotificationDTO(String jsonStringValue) {
        NotificationDTO notificationDTO;
        notificationDTO = new ObjectMapper().readValue(jsonStringValue, NotificationDTO.class);
        return Mono.just(notificationDTO);
    }
}
