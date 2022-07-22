package com.nttdata.ofertas.model.client.primaryoffer;

import com.nttdata.ofertas.model.client.primaryoffer.dto.RsPrimaryOffer;
import lombok.SneakyThrows;
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
public class PrimaryOfferClient {
    @Value("${url.primary.offer}")
    private String urlPrimaryOffer;

    @Autowired
    private RestTemplate restTemplate;

    @SneakyThrows
    public RsPrimaryOffer findPrimaryOffer(String dni) {
        String url = urlPrimaryOffer + "/" + dni;
        HttpHeaders headers = new HttpHeaders();
        headers.set("originator", "s");
        headers.set("userId", "s");
        headers.set("operation", "obtenerOfertasSecundarias");
        headers.set("execId", "550e8400-e29b-41d4-a716-446655440001");
        headers.set("Authorization", "Bearer " + "ss");

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<RsPrimaryOffer> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
        });

        return response.getBody();
    }
}
