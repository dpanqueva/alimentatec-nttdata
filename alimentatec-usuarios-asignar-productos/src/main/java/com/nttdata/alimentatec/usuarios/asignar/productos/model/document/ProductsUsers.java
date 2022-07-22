package com.nttdata.alimentatec.usuarios.asignar.productos.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product_users")
public class ProductsUsers {

    @Id
    private String id;

    @NotEmpty
    private String codeUser;

    private String name;

    private String email;


    @NotEmpty
    private String codePrincipalProduct;

    @NotEmpty
    private String namePrincipalProduct;

    private String nameSecondaryProduct;
    private String codeSecondaryProduct;
    @NotNull
    private float invoice;
    @NotEmpty
    private String snEnable;
}
