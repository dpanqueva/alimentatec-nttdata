package com.nttdata.alimentatec.producto.usuario.model.service;

import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rq.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs.ProductAssignmentWrapper;

public interface IAssignmentService {

    public ProductAssignmentWrapper recordAssignment(RQAssignmentProductUserDTO request);
}
