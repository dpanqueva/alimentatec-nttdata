package com.nttdata.alimentatec.usuarios.model.service;

import com.nttdata.alimentatec.usuarios.model.dto.UserDTO;
import com.nttdata.alimentatec.usuarios.model.entity.Users;
import com.nttdata.alimentatec.usuarios.model.entity.UsersSP;
import com.nttdata.alimentatec.usuarios.model.repository.ISPConsume;
import com.nttdata.alimentatec.usuarios.model.repository.IUserRepositoryRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService{
    @Autowired
    private ISPConsume repositoryRest;
    @Override
    public UserDTO spUsuarioActivo(String cedula) {
        UsersSP u = repositoryRest.spUsuarioActivo(cedula);

        return new ModelMapper().map(u,UserDTO.class);
    }
}
