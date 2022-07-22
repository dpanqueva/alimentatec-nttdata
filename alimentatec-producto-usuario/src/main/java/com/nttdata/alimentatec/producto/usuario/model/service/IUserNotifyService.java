package com.nttdata.alimentatec.producto.usuario.model.service;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UserDTO;

public interface IUserNotifyService {

    public void notifyUserEmail(UserDTO user);
}
