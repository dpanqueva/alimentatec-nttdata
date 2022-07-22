package com.nttdata.ofertassecundarias.controller;

import com.nttdata.ofertassecundarias.model.dto.SecondaryOfferResponseDTO;
import com.nttdata.ofertassecundarias.model.service.ISecondaryOfferService;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class SecondaryOfferController {

    @Autowired
    private ISecondaryOfferService service;

    @GetMapping
    public ResponseEntity<SecondaryOfferResponseDTO> obtainPrimaryProduct(@RequestHeader HttpHeaders headers, @RequestParam String dni){
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        dni = policy.sanitize(dni);
        return new ResponseEntity<>(service.findAll(dni), HttpStatus.OK);
    }
}
