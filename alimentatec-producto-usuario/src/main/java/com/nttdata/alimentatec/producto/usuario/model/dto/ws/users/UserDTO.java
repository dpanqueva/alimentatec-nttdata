package com.nttdata.alimentatec.producto.usuario.model.dto.ws.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("email")
    private String email;
}