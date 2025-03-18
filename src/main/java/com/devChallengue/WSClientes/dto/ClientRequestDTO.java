package com.devChallengue.WSClientes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDTO {
    private String nombre;
    private String genero;
    private Integer edad;
    private String clienteId;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;
}
