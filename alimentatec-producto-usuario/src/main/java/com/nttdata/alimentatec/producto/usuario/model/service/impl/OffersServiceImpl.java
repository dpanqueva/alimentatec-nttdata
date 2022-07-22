package com.nttdata.alimentatec.producto.usuario.model.service.impl;

import com.nttdata.alimentatec.producto.usuario.model.client.OffersClient;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;
import com.nttdata.alimentatec.producto.usuario.model.service.IOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersServiceImpl implements IOffersService {

    @Autowired
    private OffersClient offersClient;

    @Override
    public PrimaryOfferDTO offerClient(String codeProduct) {
        return offersClient.offerClient(codeProduct);
    }
}
