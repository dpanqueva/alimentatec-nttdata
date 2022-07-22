package com.nttdata.alimentatec.usuarios.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "cedula")
    private String document;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "correo")
    private String email;
    @Column(name = "snactivo")
    private String snEnable;
}
