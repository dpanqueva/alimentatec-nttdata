package com.nttdata.ofertas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecondaryOfferDTO {
    private String secondaryOfferId;
    private String secondaryOfferName;
    private String secondaryOfferPrice;
}
