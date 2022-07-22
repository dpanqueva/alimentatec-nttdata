package com.nttdata.alimentatec.registrar.producto.usuario.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RQAssignmentProductUserDTO {

    private String id;
    private String codeUser;
    private String name;
    private String email;

    private String codePrincipalProduct;
    private String namePrincipalProduct;
    private String nameSecondaryProduct;
    private String codeSecondaryProduct;
    private float invoice;
    private String snEnable;
}
