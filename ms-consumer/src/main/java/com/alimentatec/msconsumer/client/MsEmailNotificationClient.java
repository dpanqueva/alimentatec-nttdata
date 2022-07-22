package com.alimentatec.msconsumer.client;

import com.alimentatec.msconsumer.dto.RequestMsEmailInformationDTO;
import com.alimentatec.msconsumer.dto.ResponseMsEmailNotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class MsEmailNotificationClient {

    @Autowired
    private WebClient.Builder webClient;

    @Value("${ms.email.notification.service}")
    private String service;

    public Mono<ResponseMsEmailNotificationDTO> consumeMsEmailNotification(Mono<RequestMsEmailInformationDTO> requestMono){
        return webClient.build().post()
                .uri(service)
                .body(requestMono, RequestMsEmailInformationDTO.class)
                .retrieve()
                .bodyToMono(ResponseMsEmailNotificationDTO.class);
    }
}
