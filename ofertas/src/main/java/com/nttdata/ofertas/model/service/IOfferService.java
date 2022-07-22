package com.nttdata.ofertas.model.service;

import com.nttdata.ofertas.model.dto.OffersDTO;

public interface IOfferService {
    OffersDTO findOffer(String dni);
}
