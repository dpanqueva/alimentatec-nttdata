package com.nttdata.ofertas.model.client.secondaryoffer;

import com.nttdata.ofertas.model.client.secondaryoffer.dto.RsSecondaryOffer;
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
public class SecondaryOfferClient {

    @Value("${url.secondary.offer}")
    private String urlSecondaryOffer;

    @Autowired
    private RestTemplate restTemplate;

    public RsSecondaryOffer findSecondaryOffer(String dni) {
        String url = urlSecondaryOffer + "?dni=" + dni;
        HttpHeaders headers = new HttpHeaders();
        headers.set("originator", "s");
        headers.set("userId", "s");
        headers.set("operation", "obtenerOfertasSecundarias");
        headers.set("execId", "550e8400-e29b-41d4-a716-446655440001");
        headers.set("Authorization", "Bearer " + "ss");

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<RsSecondaryOffer> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
        });

        return response.getBody();
    }
}
