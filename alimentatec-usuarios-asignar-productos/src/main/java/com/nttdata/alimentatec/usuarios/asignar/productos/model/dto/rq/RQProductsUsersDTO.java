package com.nttdata.alimentatec.usuarios.asignar.productos.model.dto.rq;

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
public class RQProductsUsersDTO implements Serializable {

    private static final Long serialUUID = 1L;

    @NotEmpty
    private Long codeUser;

    @NotEmpty
    private String codeProduct;
}
