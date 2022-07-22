package com.nttdata.alimentatec.producto.usuario.model.service.impl;

import com.nttdata.alimentatec.producto.usuario.model.client.RecordAssignmentClient;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rq.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs.ProductAssignmentWrapper;
import com.nttdata.alimentatec.producto.usuario.model.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl implements IAssignmentService {

    @Autowired
    private RecordAssignmentClient recordAssignmentClient;

    @Override
    public ProductAssignmentWrapper recordAssignment(RQAssignmentProductUserDTO request) {
        return recordAssignmentClient.recordAssignment(request);
    }
}
