package com.nttdata.ofertassecundarias.model.service;

import com.nttdata.ofertassecundarias.model.dto.SecondaryOfferResponseDTO;

public interface ISecondaryOfferService {
    public SecondaryOfferResponseDTO findAll(String dni);
}
