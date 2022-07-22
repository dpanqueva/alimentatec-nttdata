package com.nttdata.alimentatec.usuarios.asignar.productos.model.repository;

import com.nttdata.alimentatec.usuarios.asignar.productos.model.document.ProductsUsers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsUsersRepository extends ReactiveMongoRepository<ProductsUsers,String> {
}
