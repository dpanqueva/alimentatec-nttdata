package com.nttdata.alimentatec.registrar.producto.usuario.model.dto.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response{
	@JsonProperty("code")
	private String code;
	@JsonProperty("serviceResponse")
	private ServiceResponse serviceResponse;
	@JsonProperty("type")
	private String type;
	@JsonProperty("message")
	private String message;
}