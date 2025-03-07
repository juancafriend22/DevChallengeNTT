package com.devChallengue.WSClientes.mapper;

import com.devChallengue.WSClientes.dto.ClienteResponseDTO;
import com.devChallengue.WSClientes.modelo.Cliente;

/*Request: El cliente envía un objeto (por ejemplo, ClienteRequestDTO) con los datos necesarios.
Transformación: Ese objeto se mapea a la entidad (Cliente) mediante un mapper.
Persistencia: Se guarda la entidad en la base de datos.
Response: Se mapea la entidad persistida a un ClienteResponseDTO y se devuelve como respuesta.
 */
public class ClienteEntityMapper {
    public static Cliente toEntity(ClienteResponseDTO dto){
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setGenero(dto.getGenero());
        entity.setEdad(dto.getEdad());
        entity.setClienteId(dto.getClienteId());
        entity.setIdentificacion(dto.getIdentificacion());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setContrasena(dto.getContrasena());
        entity.setEstado(dto.isEstado());
        return entity;
    }

    public static ClienteResponseDTO toDTO(Cliente entity){
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setGenero(entity.getGenero());
        dto.setEdad(entity.getEdad());
        dto.setClienteId(entity.getClienteId());
        dto.setIdentificacion(entity.getIdentificacion());
        dto.setDireccion(entity.getDireccion());
        dto.setTelefono(entity.getTelefono());
        dto.setContrasena(entity.getContrasena());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}
