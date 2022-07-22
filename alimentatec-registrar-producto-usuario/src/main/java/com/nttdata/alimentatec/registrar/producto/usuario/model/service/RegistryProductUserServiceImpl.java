package com.nttdata.alimentatec.registrar.producto.usuario.model.service;

import com.nttdata.alimentatec.registrar.producto.usuario.model.client.AssignmentUserProductClient;
import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryProductUserServiceImpl implements IRegistryProductUserService {

    @Autowired
    private AssignmentUserProductClient assUsProClient;

    @Override
    public Response userProductClient(RQAssignmentProductUserDTO request) {
        request.setSnEnable("S");
        return assUsProClient.userProductClient(request);
    }
}
