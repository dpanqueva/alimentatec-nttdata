package com.nttdata.alimentatec.usuarios.asignar.productos.controller;

import com.nttdata.alimentatec.usuarios.asignar.productos.model.document.ProductsUsers;
import com.nttdata.alimentatec.usuarios.asignar.productos.model.dto.rs.RSProductUsersDTO;
import com.nttdata.alimentatec.usuarios.asignar.productos.model.service.IProductUserService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductUserController {
    @Autowired
    private IProductUserService productUserService;

    @PostMapping("/assign-user-product")
    public Mono<ResponseEntity<Map<String, Object>>> assignUserProduct(@Valid @RequestBody Mono<ProductsUsers> monoProduct) {

        return monoProduct.flatMap(product ->
                productUserService.save(product)
                        .map(p ->
                                ResponseEntity.created(URI.create("/api/v1/assign-user-product".concat("")))
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .headers(buildHeaders("RESPONSE"))
                                        .body(buildResponse(
                                                p, "SUCCESS"
                                                , "Association SUCCESS user product"
                                                , "201"
                                        ))
                        )
        ).onErrorResume(t ->
                Mono.just(t).cast(WebExchangeBindException.class)
                        .flatMap(e -> Mono.just(e.getFieldErrors()))
                        .flatMapMany(Flux::fromIterable)
                        .map(fieldError -> "The field ".concat(fieldError.getField()).concat(" ")
                                .concat(fieldError.getDefaultMessage()))
                        .collectList()
                        .flatMap(list ->
                                Mono.just(ResponseEntity.badRequest()
                                        .headers(buildHeaders("RESPONSE"))
                                        .body(buildResponse(new RSProductUsersDTO()
                                                , "SUCCESS"
                                                , "The change was scheduled successfully"
                                                , "201"
                                        )))
                        )
        );

    }

    public Map<String, Object> buildResponse(RSProductUsersDTO rsChangePassWifiDTO, String eResponseType
            , Object message, String code) {
        Map<String, Object> response = new HashMap<>();
        response.put("serviceResponse", rsChangePassWifiDTO);
        response.put("type", eResponseType);
        response.put("message", message);
        response.put("code", code);
        return response;
    }

    public HttpHeaders buildHeaders(String headerValue) {
        var headers = new HttpHeaders();
        headers.add("msgType", StringEscapeUtils.escapeHtml4(headerValue));
        return headers;
    }
}
