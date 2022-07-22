package com.nttdata.ofertas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffersDTO {
    private String productPrimaryId;
    private String productPrimaryName;
    private String productPrimaryPrice;
    private SecondaryOfferDTO secondaryOffer;
}
