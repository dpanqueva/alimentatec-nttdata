package com.nttdata.alimentatec.producto.usuario.model.facade;

import com.nttdata.alimentatec.producto.usuario.model.dto.RQProductUserDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.assignment.rs.ProductAssignmentWrapper;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.offers.PrimaryOfferDTO;
import com.nttdata.alimentatec.producto.usuario.model.dto.ws.users.UsersWrapper;
import com.nttdata.alimentatec.producto.usuario.model.service.IAssignmentService;
import com.nttdata.alimentatec.producto.usuario.model.service.IOffersService;
import com.nttdata.alimentatec.producto.usuario.model.service.IUserNotifyService;
import com.nttdata.alimentatec.producto.usuario.model.service.IUserService;
import com.nttdata.alimentatec.producto.usuario.util.AssignmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFacade {

    @Autowired
    private IOffersService offersService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAssignmentService assignmentService;

    @Autowired
    private IUserNotifyService userNotifyService;

    @Autowired
    private AssignmentUtil assignmentUtil;



    public ProductAssignmentWrapper buildAssignment(RQProductUserDTO request) {
        UsersWrapper usersWrapper = userService.userClient(request.getCodeUser());
        PrimaryOfferDTO primaryOffer = offersService.offerClient(request.getCodeProduct());
        ProductAssignmentWrapper response = assignmentService.recordAssignment(assignmentUtil.assignmentProductUser(usersWrapper, primaryOffer
                , request.getCodeUser()));
        userNotifyService.notifyUserEmail(usersWrapper.getUserDTO());

        /**
         * Assignment your product to user
         * */
        return response;

    }
}
