package com.nttdata.productosprimarios.model.dto;

import com.nttdata.productosprimarios.model.document.PrimaryProductDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PrimaryProductDTO {
    private String productPrimaryId;
    private String productPrimaryName;
    private BigInteger productPrimaryPrice;

    public PrimaryProductDTO(PrimaryProductDocument primaryProductDocument) {
        productPrimaryId = primaryProductDocument.getProductPrimaryId();
        productPrimaryName = primaryProductDocument.getProductPrimaryName();
        productPrimaryPrice = primaryProductDocument.getProductPrimaryPrice();
    }
}
