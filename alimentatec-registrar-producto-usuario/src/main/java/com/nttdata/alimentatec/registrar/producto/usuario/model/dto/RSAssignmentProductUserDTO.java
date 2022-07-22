package com.nttdata.alimentatec.registrar.producto.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RSAssignmentProductUserDTO {
    private String id;
    private String name;

    private String codePrincipalProduct;
    private String namePrincipalProduct;

    private float invoice;

}
