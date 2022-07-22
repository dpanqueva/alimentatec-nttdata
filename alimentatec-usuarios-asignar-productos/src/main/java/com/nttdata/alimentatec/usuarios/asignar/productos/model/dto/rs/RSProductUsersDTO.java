package com.nttdata.alimentatec.usuarios.asignar.productos.model.dto.rs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RSProductUsersDTO implements Serializable {

    private static final Long serialUUID = 1L;

    private String nameUser;

    private String email;

    private String nameProductPrincipal;

    private String nameProductSecondary;

    private String codeProduct;

    private float invoice;


}
