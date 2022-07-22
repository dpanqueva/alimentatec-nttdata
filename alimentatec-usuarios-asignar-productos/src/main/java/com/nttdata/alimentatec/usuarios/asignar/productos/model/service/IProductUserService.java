package com.nttdata.alimentatec.usuarios.asignar.productos.model.service;

import com.nttdata.alimentatec.usuarios.asignar.productos.model.document.ProductsUsers;
import com.nttdata.alimentatec.usuarios.asignar.productos.model.dto.rs.RSProductUsersDTO;
import reactor.core.publisher.Mono;

public interface IProductUserService {

    public Mono<RSProductUsersDTO> save (ProductsUsers productUsers);
}
