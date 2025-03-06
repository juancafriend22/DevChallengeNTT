package com.devChallengue.WSClientes.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")

public class Cliente extends Persona{

    @Column(unique = true)
    private String clienteId;

    private String contrasena;
    private Boolean estado;


}
