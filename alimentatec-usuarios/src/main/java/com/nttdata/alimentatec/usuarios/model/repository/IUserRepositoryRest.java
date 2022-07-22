package com.nttdata.alimentatec.usuarios.model.repository;

import com.nttdata.alimentatec.usuarios.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface IUserRepositoryRest extends JpaRepository<Users, Long> {

}
