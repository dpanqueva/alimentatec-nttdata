package com.nttdata.productosprimarios.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productos_primarios")
public class PrimaryProductDocument {
    @Field("product_primary_id")
    private String productPrimaryId;

    @Field("product_primary_name")
    private String productPrimaryName;

    @Field("product_primary_price")
    private BigInteger productPrimaryPrice;
}
