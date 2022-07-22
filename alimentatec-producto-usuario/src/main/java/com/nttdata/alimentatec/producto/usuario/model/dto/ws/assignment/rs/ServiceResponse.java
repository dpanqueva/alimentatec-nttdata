package com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse{

	@JsonProperty("nameProductPrincipal")
	private String nameProductPrincipal;
	@JsonProperty("nameUser")
	private String nameUser;
	@JsonProperty("codeProduct")
	private String codeProduct;
	@JsonProperty("invoice")
	private double invoice;
	@JsonProperty("email")
	private String email;
	@JsonProperty("nameProductSecondary")
	private String nameProductSecondary;
}