package com.nttdata.alimentatec.producto.usuario.model.dto.ws.usernotify.rs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RSNotifyUser {
	@JsonProperty("code")
	private String code;
	@JsonProperty("type")
	private String type;
	@JsonProperty("message")
	private String message;
}