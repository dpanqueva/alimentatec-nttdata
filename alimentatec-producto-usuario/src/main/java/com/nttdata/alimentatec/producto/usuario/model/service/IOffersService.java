package com.nttdata.alimentatec.producto.usuario.model.service;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;

public interface IOffersService {

    public PrimaryOfferDTO offerClient(String codeProduct);
}
