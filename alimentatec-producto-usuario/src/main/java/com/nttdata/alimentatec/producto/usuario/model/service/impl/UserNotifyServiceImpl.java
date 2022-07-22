package com.nttdata.alimentatec.producto.usuario.model.service.impl;

import com.nttdata.alimentatec.producto.usuario.model.client.UserNotifyClient;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.usernotify.rq.UserNotifyDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UserDTO;
import com.nttdata.alimentatec.producto.usuario.model.service.IUserNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserNotifyServiceImpl implements IUserNotifyService {

    @Autowired
    private UserNotifyClient usersNotifyClient;

    @Value("${msg.payload.notify}")
    private String message;

    @Override
    public void notifyUserEmail(UserDTO user) {
        usersNotifyClient.userClient(new UserNotifyDTO(UUID.randomUUID().toString(), user.getEmail(),
                message));
    }
}
