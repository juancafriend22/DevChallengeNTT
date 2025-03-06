package com.devChallengue.WSClientes.mapper;

import com.devChallengue.WSClientes.dto.ClienteDTO;
import com.devChallengue.WSClientes.dto.ClienteRequestDTO;

/*Aqui se converte un objeto recibido en la peticion (ClienteRequestDTO) a
un objeto intermedio (ClienteDTO)*/
public class ClienteRequestMapper {
    public static ClienteDTO toClienteDTO(ClienteRequestDTO request){
      ClienteDTO dto = new ClienteDTO();
      dto.setNombre(request.getNombre());
      dto.setGenero(request.getGenero());
      dto.setEdad(request.getEdad());
      dto.setIdentificacion(request.getIdentificacion());
      dto.setDireccion(request.getIdentificacion());
      dto.setTelefono(request.getTelefono());
      dto.setContrasena(request.getContrasena());
      dto.setEstado(request.isEstado());
      return dto;

    }
}
