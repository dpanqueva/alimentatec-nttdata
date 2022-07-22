package com.nttdata.alimentatec.producto.usuario.controller;

import com.nttdata.alimentatec.producto.usuario.model.dto.RQProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.facade.ProductClientFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("product-user")
public class ProductUserController {


    @Autowired
    private ProductClientFacade facade;

    @PostMapping
    public ResponseEntity<Map<String, Object>> assignmentProductUser(@RequestBody RQProductUserDTO productUser) {
        Map<String, Object> response = new HashMap<>();
        response.put("serviceResponse", facade.buildAssignment(productUser));
        return ResponseEntity.created(URI.create("/product-user")).body(response);
    }
}
