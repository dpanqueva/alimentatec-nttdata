package com.nttdata.ofertassecundarias.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SecondaryOfferResponseDTO {
    @JsonAlias("secondaryOfferId")
    private String secondaryOfferId;
    @JsonAlias("secondaryOfferName")
    private String secondaryOfferName;
    @JsonAlias("secondaryOfferPrice")
    private BigInteger secondaryOfferPrice;
}
