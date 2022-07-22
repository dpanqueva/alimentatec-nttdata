package com.nttdata.ofertas.model.client.primaryoffer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RsPrimaryOffer {
    private String productPrimaryId;
    private String productPrimaryName;
    private String productPrimaryPrice;
}
