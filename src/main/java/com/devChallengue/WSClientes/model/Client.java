package com.devChallengue.WSClientes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")

public class Client extends Person {
    @Column(unique = true)
    private String clienteId;

    private String contrasena;
    private Boolean estado;


}
