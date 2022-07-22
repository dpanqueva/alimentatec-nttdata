package com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RQAssignmentProductUserDTO {

    private String name;
    private String email;
    private String codeUser;

    private String namePrincipalProduct;
    private String codePrincipalProduct;
    private double invoice;
    private String codeSecondaryProduct;
    private String nameSecondaryProduct;
    private String snEnable;
}