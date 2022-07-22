package com.nttdata.alimentatec.registrar.producto.usuario.model.client;

import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.ws.Response;
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
public class AssignmentUserProductClient {

    @Value("${url.assignment.product}")
    private String url;

    @Autowired
    private RestTemplate userProductClient;

    public Response userProductClient(RQAssignmentProductUserDTO request) {
        var headers = new HttpHeaders();
        var requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<Response> responseWS = userProductClient.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Response>() {
        });

        return responseWS.getBody();
    }
}
