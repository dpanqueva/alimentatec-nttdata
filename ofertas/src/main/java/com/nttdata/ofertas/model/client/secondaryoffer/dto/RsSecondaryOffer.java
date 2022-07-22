package com.nttdata.ofertas.model.client.secondaryoffer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RsSecondaryOffer {
    private String secondaryOfferId;
    private String secondaryOfferName;
    private String secondaryOfferPrice;
}
