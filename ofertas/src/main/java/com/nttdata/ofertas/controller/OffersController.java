package com.nttdata.ofertas.controller;

import com.nttdata.ofertas.model.dto.OffersDTO;
import com.nttdata.ofertas.model.service.IOfferService;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private IOfferService service;

    @GetMapping("/{dni}")
    public ResponseEntity<OffersDTO> findOffer(@RequestHeader HttpHeaders headers, @PathVariable String dni){
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        dni = policy.sanitize(dni);
        return new ResponseEntity<>(service.findOffer(dni), HttpStatus.OK);
    }
}
