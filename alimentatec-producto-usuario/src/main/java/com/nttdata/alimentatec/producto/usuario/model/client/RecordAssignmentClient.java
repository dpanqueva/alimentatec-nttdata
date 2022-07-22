package com.nttdata.alimentatec.producto.usuario.model.client;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rq.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs.ProductAssignmentWrapper;
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
public class RecordAssignmentClient {

    @Value("${url.record.assignment}")
    private String url;

    @Autowired
    private RestTemplate recordAssignmentClient;

    public ProductAssignmentWrapper recordAssignment(RQAssignmentProductUserDTO request) {
        var headers = new HttpHeaders();
        var requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<ProductAssignmentWrapper> responseWS = recordAssignmentClient.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ProductAssignmentWrapper>() {
        });

        return responseWS.getBody();
    }
}
