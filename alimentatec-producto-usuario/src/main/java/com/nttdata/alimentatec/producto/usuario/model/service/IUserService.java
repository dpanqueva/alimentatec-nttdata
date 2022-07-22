package com.nttdata.alimentatec.producto.usuario.model.service;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UsersWrapper;

public interface IUserService {

    public UsersWrapper userClient(String document);

}
