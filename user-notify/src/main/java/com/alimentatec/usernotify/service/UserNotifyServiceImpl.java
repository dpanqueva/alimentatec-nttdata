package com.alimentatec.usernotify.service;

import com.alimentatec.usernotify.client.MsProducerClient;
import com.alimentatec.usernotify.common.model.dto.response.ResponseDTO;
import com.alimentatec.usernotify.dto.RequestMsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Slf4j
@Service
public class UserNotifyServiceImpl implements IUserNotifyService {

    @Autowired
    private MsProducerClient msProducerClient;

    @Override
    public ResponseDTO sendUserNotify(RequestMsProducer requestMsProducer){
        return msProducerClient.consumerMsProducer(requestMsProducer);
    }
}
