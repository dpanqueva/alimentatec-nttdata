package com.nttdata.ofertas.util;

import com.nttdata.ofertas.model.client.primaryoffer.dto.RsPrimaryOffer;
import com.nttdata.ofertas.model.client.secondaryoffer.dto.RsSecondaryOffer;
import com.nttdata.ofertas.model.dto.OffersDTO;
import com.nttdata.ofertas.model.dto.SecondaryOfferDTO;
import org.springframework.stereotype.Component;

@Component
public class OfferUtil {

    public OffersDTO offerMapper(RsPrimaryOffer primaryOffer, RsSecondaryOffer secondaryOffer){

        var offerDTO = new OffersDTO();
        offerDTO.setProductPrimaryId(primaryOffer.getProductPrimaryId());
        offerDTO.setProductPrimaryName(primaryOffer.getProductPrimaryName());
        offerDTO.setProductPrimaryPrice(primaryOffer.getProductPrimaryPrice());
        var secondaryOffersDTO = new SecondaryOfferDTO();
        secondaryOffersDTO.setSecondaryOfferId(secondaryOffer.getSecondaryOfferId());
        secondaryOffersDTO.setSecondaryOfferName(secondaryOffer.getSecondaryOfferName());
        secondaryOffersDTO.setSecondaryOfferPrice(secondaryOffer.getSecondaryOfferPrice());
        offerDTO.setSecondaryOffer(secondaryOffersDTO);
        return offerDTO;
    }
}
