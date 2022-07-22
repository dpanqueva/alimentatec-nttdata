package com.nttdata.alimentatec.usuarios.model.repository;

import com.nttdata.alimentatec.usuarios.model.entity.UsersSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISPConsume extends JpaRepository<UsersSP, Long> {
    @Query(value = "call sp_usuario_activo_cedula(:p_cedula,'name','correo',0,'exec')", nativeQuery = true)
    public UsersSP spUsuarioActivo(@Param("p_cedula") String cedula);
}
