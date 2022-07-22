package com.nttdata.alimentatec.producto.usuario.model.client;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.usernotify.rq.UserNotifyDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.usernotify.rs.RSNotifyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserNotifyClient {

    @Value("${url.user.notify}")
    private String url;

    @Autowired
    private RestTemplate userClient;

    public RSNotifyUser userClient(UserNotifyDTO request) {
        var headers = new HttpHeaders();
        var requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<RSNotifyUser> responseWs = userClient.exchange(url, HttpMethod.POST, requestEntity
                , new ParameterizedTypeReference<>() {
                });
        return responseWs.getBody();
    }
}
