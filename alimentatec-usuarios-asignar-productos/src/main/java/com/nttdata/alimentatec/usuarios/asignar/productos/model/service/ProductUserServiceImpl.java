package com.nttdata.alimentatec.usuarios.asignar.productos.model.service;

import com.nttdata.alimentatec.usuarios.asignar.productos.model.document.ProductsUsers;
import com.nttdata.alimentatec.usuarios.asignar.productos.model.dto.rs.RSProductUsersDTO;
import com.nttdata.alimentatec.usuarios.asignar.productos.model.repository.IProductsUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductUserServiceImpl implements IProductUserService {
    @Autowired
    private IProductsUsersRepository productsUsersRepository;


    @Override
    public Mono<RSProductUsersDTO> save(ProductsUsers productUsers) {
        /** obtenemos el usuario*/
        return productsUsersRepository.save(productUsers).map(pu -> new RSProductUsersDTO(
                        pu.getName(), pu.getEmail(), pu.getNamePrincipalProduct(), pu.getNameSecondaryProduct(),
                        pu.getId(), pu.getInvoice()
                )
        );
    }
}
