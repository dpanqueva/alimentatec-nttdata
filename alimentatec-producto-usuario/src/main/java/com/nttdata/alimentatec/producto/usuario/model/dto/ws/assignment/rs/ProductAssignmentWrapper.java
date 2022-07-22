package com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAssignmentWrapper {
	@JsonProperty("passed")
	private Passed passed;
	@JsonProperty("message")
	private String message;
}