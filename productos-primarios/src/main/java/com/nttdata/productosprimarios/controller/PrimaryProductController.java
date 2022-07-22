package com.nttdata.productosprimarios.controller;

import com.nttdata.productosprimarios.model.dto.PrimaryProductDTO;
import com.nttdata.productosprimarios.model.service.IPrimaryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class PrimaryProductController {

    @Autowired
    private IPrimaryProductService service;

    @GetMapping("/{productPrimaryId}")
    public Mono<ResponseEntity<PrimaryProductDTO>> obtainPrimaryProduct(@RequestHeader HttpHeaders headers, @PathVariable String productPrimaryId) {

        return service.findByProductPrimaryId(productPrimaryId).map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
