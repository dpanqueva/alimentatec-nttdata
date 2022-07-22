package com.nttdata.alimentatec.producto.usuario.model.client;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OffersClient {

    @Value("${url.offers}")
    private String url;

    @Autowired
    private RestTemplate offerClient;

    public PrimaryOfferDTO offerClient(String codeProduct) {
        ResponseEntity<PrimaryOfferDTO> responseWs = offerClient.exchange(url.concat("/").concat(codeProduct), HttpMethod.GET, null
                , new ParameterizedTypeReference<>() {
                });
        return responseWs.getBody();

    }
}
