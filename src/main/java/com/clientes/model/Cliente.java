package com.clientes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "clientes")
@Entity
public class Cliente {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
