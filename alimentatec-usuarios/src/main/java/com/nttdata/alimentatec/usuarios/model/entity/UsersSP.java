package com.nttdata.alimentatec.usuarios.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Immutable
public class UsersSP {

    @Id
    @Column(name = "s_id")
    private Long id;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_correo")
    private String email;
    @Column(name = "p_exec")
    private String exec;
}
