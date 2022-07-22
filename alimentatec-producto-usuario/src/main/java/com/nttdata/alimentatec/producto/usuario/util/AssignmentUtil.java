package com.nttdata.alimentatec.producto.usuario.util;

import com.nttdata.alimentatec.producto.usuario.exceptions.NotContentException;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rq.RQAssignmentProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UsersWrapper;
import org.springframework.stereotype.Component;

@Component
public class AssignmentUtil {


    public RQAssignmentProductUserDTO assignmentProductUser(UsersWrapper usersWrapper, PrimaryOfferDTO primaryOfferDTO
            , String codeUser) {
        RQAssignmentProductUserDTO assignmentProductUserDTO = new RQAssignmentProductUserDTO();
        if (usersWrapper == null) {
            throw new NotContentException("Object empty");
        }
        if (usersWrapper.getUserDTO() == null) {
            throw new NotContentException("User empty");
        }
        if (primaryOfferDTO == null) {
            throw new NotContentException("Offer product empty");
        }
        if (primaryOfferDTO.getSecondaryOfferDTO() != null) {
            assignmentProductUserDTO.setCodeSecondaryProduct(primaryOfferDTO.getSecondaryOfferDTO().getSecondaryOfferId());
            assignmentProductUserDTO.setNameSecondaryProduct(primaryOfferDTO.getSecondaryOfferDTO().getSecondaryOfferName());
        }

        assignmentProductUserDTO.setCodeUser(codeUser);
        assignmentProductUserDTO.setName(usersWrapper.getUserDTO().getName());
        assignmentProductUserDTO.setEmail(usersWrapper.getUserDTO().getEmail());
        assignmentProductUserDTO.setCodePrincipalProduct(primaryOfferDTO.getProductPrimaryId());
        assignmentProductUserDTO.setNamePrincipalProduct(primaryOfferDTO.getProductPrimaryName());
        assignmentProductUserDTO.setInvoice(Double.parseDouble(primaryOfferDTO.getProductPrimaryPrice()));
        assignmentProductUserDTO.setSnEnable("S");
        return assignmentProductUserDTO;
    }
}
