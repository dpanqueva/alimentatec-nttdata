package com.nttdata.alimentatec.producto.usuario.model.dto.ws.usernotify.rq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserNotifyDTO {

    private String msisdn;

    private String email;

    private String payLoad;
}
