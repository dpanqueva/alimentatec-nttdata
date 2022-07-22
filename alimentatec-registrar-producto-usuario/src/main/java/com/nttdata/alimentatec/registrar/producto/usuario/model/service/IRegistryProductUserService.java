package com.nttdata.alimentatec.registrar.producto.usuario.model.service;

import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.registrar.producto.usuario.model.dto.ws.Response;

public interface IRegistryProductUserService {


    public Response userProductClient(RQAssignmentProductUserDTO request);
}
