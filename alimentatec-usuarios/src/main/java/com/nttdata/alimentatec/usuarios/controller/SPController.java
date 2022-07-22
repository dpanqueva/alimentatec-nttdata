package com.nttdata.alimentatec.usuarios.controller;

import com.nttdata.alimentatec.usuarios.model.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class SPController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("cedula/{cedula}")
    public ResponseEntity<?> execSP(@PathVariable String cedula) {
        Map<String, Object> response = new HashMap<>();
        response.put("respuesta", usersService.spUsuarioActivo(cedula));
        return ResponseEntity.ok(response);
    }
}
