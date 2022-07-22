package com.alimentatec.usernotify.service;

import com.alimentatec.usernotify.common.model.dto.response.ResponseDTO;
import com.alimentatec.usernotify.dto.RequestMsProducer;

import java.net.URISyntaxException;

public interface IUserNotifyService {
    public ResponseDTO sendUserNotify(RequestMsProducer requestMsProducer);
}
