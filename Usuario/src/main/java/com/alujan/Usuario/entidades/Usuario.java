package com.alujan.Usuario.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="usuario_id")
    private Integer Id;
    @Column(name="celular")
    private String Cellphone;
    @Column(name="nombre")
    private String Name;
    @Column(name="apellido")
    private String LastName;
    @Column(name="password")
    private String Password;


}
