package com.devChallengue.WSClientes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long id; //Campo que hereda de persona si le quito de aqui no hay respuesta en el json del campo id
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String clienteId;
    private String contrasena;
    private boolean estado;


}
