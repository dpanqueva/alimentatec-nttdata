package com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryOfferDTO {
    @JsonProperty("productPrimaryId")
    private String productPrimaryId;
    @JsonProperty("productPrimaryName")
    private String productPrimaryName;
    @JsonProperty("productPrimaryPrice")
    private String productPrimaryPrice;
    @JsonProperty("secondaryOffer")
    private SecondaryOfferDTO secondaryOfferDTO;
}