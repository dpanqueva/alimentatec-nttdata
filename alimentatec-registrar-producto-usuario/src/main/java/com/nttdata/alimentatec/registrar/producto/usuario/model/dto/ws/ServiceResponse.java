package com.nttdata.alimentatec.registrar.producto.usuario.model.dto.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse{
	@JsonProperty("nameProductPrincipal")
	private String nameProductPrincipal;
	@JsonProperty("nameUser")
	private String nameUser;
	@JsonProperty("codeProduct")
	private String codeProduct;
	@JsonProperty("email")
	private String email;
	@JsonProperty("nameProductSecondary")
	private String nameProductSecondary;
	@JsonProperty("invoice")
	private float invoice;

}