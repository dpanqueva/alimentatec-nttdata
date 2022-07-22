package com.alimentatec.msproducer.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationHandler {

    @Autowired
    private HashMap<String, Object> responseMap;

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<Map<String, Object>>> validRequestBodyException(WebExchangeBindException e){
        var errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        responseMap.put("errors",errors);
        responseMap.put("timestamp", new Date());
        responseMap.put("status", HttpStatus.BAD_REQUEST.value());
        return Mono.just(ResponseEntity.badRequest().body(responseMap));
    }
}
