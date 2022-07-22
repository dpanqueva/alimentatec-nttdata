package com.nttdata.alimentatec.producto.usuario.model.service.impl;

import com.nttdata.alimentatec.producto.usuario.model.client.UsersClient;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UsersWrapper;
import com.nttdata.alimentatec.producto.usuario.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UsersClient usersClient;
    @Override
    public UsersWrapper userClient(String document) {
        return usersClient.userClient(document);
    }
}
