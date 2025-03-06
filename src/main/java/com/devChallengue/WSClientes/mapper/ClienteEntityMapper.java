package com.devChallengue.WSClientes.mapper;

import com.devChallengue.WSClientes.dto.ClienteDTO;
import com.devChallengue.WSClientes.modelo.Cliente;

/*Aqui se realiza la conversión entre el objeto intermedio Clienteentity
y la entidad que se persiste en la base de datos (Cliente)
 */
public class ClienteEntityMapper {
    public static Cliente toEntity(ClienteDTO dto){
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setGenero(dto.getGenero());
        entity.setEdad(dto.getEdad());
        entity.setClienteId(dto.getClienteId());
        entity.setIdentificacion(dto.getIdentificacion());
        entity.setDireccion(dto.getIdentificacion());
        entity.setTelefono(dto.getTelefono());
        entity.setContrasena(dto.getContrasena());
        entity.setEstado(dto.isEstado());
        return entity;
    }

    public static ClienteDTO toDTO(Cliente entity){
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setGenero(entity.getGenero());
        dto.setEdad(entity.getEdad());
        dto.setIdentificacion(entity.getIdentificacion());
        dto.setDireccion(entity.getIdentificacion());
        dto.setTelefono(entity.getTelefono());
        dto.setContrasena(entity.getContrasena());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}
