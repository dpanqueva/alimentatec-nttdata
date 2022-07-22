package com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passed{
	@JsonProperty("code")
	private String code;
	@JsonProperty("serviceResponse")
	private ServiceResponse serviceResponse;
	@JsonProperty("type")
	private String type;
	@JsonProperty("message")
	private String message;
}