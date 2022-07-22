package com.nttdata.alimentatec.registrar.producto.usuario.controller;

import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.registrar.producto.usuario.model.service.IRegistryProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("assignment-product-user")
public class AssignmentProductUserController {

    @Autowired
    private IRegistryProductUserService registryProductUserService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> assignmentProductUser(@RequestBody RQAssignmentProductUserDTO assignmentProductUserDTO) {
        Map<String, Object> response = new HashMap<>();
        response.put("passed", registryProductUserService.userProductClient(assignmentProductUserDTO));
        response.put("message", "The approval of your product is satisfactory");
        return ResponseEntity.ok().body(response);

    }
}
