package com.nttdata.alimentatec.producto.usuario.model.dto.ws.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersWrapper {

	@JsonProperty("respuesta")
	private UserDTO userDTO;
}