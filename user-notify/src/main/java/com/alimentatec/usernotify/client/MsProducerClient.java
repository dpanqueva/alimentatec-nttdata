package com.alimentatec.usernotify.client;

import com.alimentatec.usernotify.common.model.dto.response.ResponseDTO;
import com.alimentatec.usernotify.common.model.enums.EResponseType;
import com.alimentatec.usernotify.dto.RequestMsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

@Slf4j
@Component
public class MsProducerClient {

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Value("${ms.producer.url}")
    private String url;

    @Value("${ms.producer.service}")
    private String service;

    public ResponseDTO consumerMsProducer(RequestMsProducer requestMsProducer){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<RequestMsProducer> entity = new HttpEntity<>(requestMsProducer, headers);
        ResponseEntity<Object> objectResponseEntity = restTemplate.exchange(url+service, HttpMethod.POST, entity, Object.class);
        ResponseDTO responseDTO = new ResponseDTO();
        if(objectResponseEntity.getStatusCodeValue()==202){
            responseDTO.setCode("200");
            responseDTO.setMessage("Consume to ms-producer");
            responseDTO.setType(EResponseType.SUCCESS);
        }
        return responseDTO;
    }
}
