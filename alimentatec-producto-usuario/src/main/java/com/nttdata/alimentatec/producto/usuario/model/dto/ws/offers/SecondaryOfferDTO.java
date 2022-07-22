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
public class SecondaryOfferDTO {
	@JsonProperty("secondaryOfferId")
	private String secondaryOfferId;
	@JsonProperty("secondaryOfferName")
	private String secondaryOfferName;
	@JsonProperty("secondaryOfferPrice")
	private String secondaryOfferPrice;
}