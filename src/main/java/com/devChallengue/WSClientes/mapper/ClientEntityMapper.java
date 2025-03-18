package com.devChallengue.WSClientes.mapper;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.model.Client;

/*Request: El cliente envía un objeto (por ejemplo, ClienteRequestDTO) con los datos necesarios.
Transformación: Ese objeto se mapea a la entidad (Cliente) mediante un mapper.
Persistencia: Se guarda la entidad en la base de datos.
Response: Se mapea la entidad persistida a un ClienteResponseDTO y se devuelve como respuesta.
 */
public class ClientEntityMapper {
    public static Client toEntity(ClientDTO dto){
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setGenero(dto.getGenero());
        entity.setEdad(dto.getEdad());
        entity.setClienteId(dto.getClienteId());
        entity.setIdentificacion(dto.getIdentificacion());
        entity.setDireccion(dto.getDireccion());
        entity.setTelefono(dto.getTelefono());
        entity.setContrasena(dto.getContrasena());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public static ClientDTO toDTO(Client entity){
        ClientDTO dto = new ClientDTO();
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
