package com.nttdata.ofertas.model.service;

import com.nttdata.ofertas.common.exception.NotContentException;
import com.nttdata.ofertas.model.client.primaryoffer.PrimaryOfferClient;
import com.nttdata.ofertas.model.client.primaryoffer.dto.RsPrimaryOffer;
import com.nttdata.ofertas.model.client.secondaryoffer.SecondaryOfferClient;
import com.nttdata.ofertas.model.client.secondaryoffer.dto.RsSecondaryOffer;
import com.nttdata.ofertas.model.dto.OffersDTO;
import com.nttdata.ofertas.util.OfferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements IOfferService {

    @Autowired
    private PrimaryOfferClient primaryOfferClient;

    @Autowired
    private SecondaryOfferClient secondaryOfferClient;

    @Autowired
    private OfferUtil offerUtil;

    public OffersDTO findOffer(String dni) {

        RsPrimaryOffer primaryOfferResponse = primaryOfferClient.findPrimaryOffer(dni);
        if (primaryOfferResponse.getProductPrimaryId() == null){
            throw new NotContentException("No se encontraron resultados para tu busqueda");
        }
        RsSecondaryOffer secondaryOfferResponse = secondaryOfferClient.findSecondaryOffer(dni);
        if (secondaryOfferResponse.getSecondaryOfferId() == null){
            throw new NotContentException("No se encontraron resultados para tu busqueda");
        }
        return offerUtil.offerMapper(primaryOfferResponse, secondaryOfferResponse);
    }
}
