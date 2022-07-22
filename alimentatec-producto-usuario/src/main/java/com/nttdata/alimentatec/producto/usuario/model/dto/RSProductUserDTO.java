package com.nttdata.alimentatec.producto.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RSProductUserDTO {

    private int id;

    private String codeUser;

    private String name;

    private String namePrincipalProduct;
    private String nameSecondaryProduct;
    private float invoice;

}
