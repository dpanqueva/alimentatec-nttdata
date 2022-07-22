package com.nttdata.alimentatec.producto.usuario.model.client;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UsersClient {

    @Value("${url.users}")
    private String url;

    @Autowired
    private RestTemplate userClient;

    public UsersWrapper userClient(String document) {
        ResponseEntity<UsersWrapper> responseWs = userClient.exchange(url.concat("/").concat(document), HttpMethod.GET, null
                , new ParameterizedTypeReference<>() {
                });
        return responseWs.getBody();
    }
}
