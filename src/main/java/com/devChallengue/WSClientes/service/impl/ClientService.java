package com.devChallengue.WSClientes.service.impl;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.exception.ClientCreationException;
import com.devChallengue.WSClientes.exception.ClientNotFoundException;
import com.devChallengue.WSClientes.mapper.ClientEntityMapper;
import com.devChallengue.WSClientes.model.Client;
import com.devChallengue.WSClientes.repository.ClientRepository;
import com.devChallengue.WSClientes.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    // POST: Crear cliente
    @Override
    public ClientDTO crearCliente(ClientDTO clientDTO) {
        try {
            Client clientEntity = ClientEntityMapper.toEntity(clientDTO);
            Client clientGuardado = clientRepository.save(clientEntity);
            return ClientEntityMapper.toDTO(clientGuardado);
        } catch (Exception e) {
            // Maneja errores específicos
            throw new ClientCreationException("Error al crear cliente en la base de datos.");
        }
    }

    // GET: Obtener cliente por id
    @Override
    public ClientDTO obtenerClientePorId(Long id) {
        Client clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Cliente con ID " + id + " no encontrado."));

        return ClientEntityMapper.toDTO(clientEntity);
    }

    // GET: Listar todos los clientes
    @Override
    public List<ClientDTO> obtenerTodosClientes() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new ClientNotFoundException("No existen clientes registrados.");
        }

        return clients.stream()
                .map(ClientEntityMapper::toDTO)
                .collect(Collectors.toList());
    }

    // DELETE: Eliminar cliente por id
    @Override
    public boolean  eliminarCliente(Long id) {
        if (!clientRepository.existsById(id)) {
                throw new ClientNotFoundException("Cliente con ID " + id + " no encontrado para eliminar.");
        }
        clientRepository.deleteById(id);
            return true;
    }

    @Override
    public ClientDTO actualizarCliente(Long id, ClientDTO cli) {
        try{
            Client clienteExistente = ClientEntityMapper.toEntity(obtenerClientePorId(id));
                clienteExistente.setEdad(cli.getEdad());
                clienteExistente.setDireccion(cli.getDireccion());
                clienteExistente.setContrasena(cli.getContrasena());
                clienteExistente.setEstado(cli.getEstado());
                clienteExistente.setNombre(cli.getNombre());
                clienteExistente.setIdentificacion(cli.getIdentificacion());
                clienteExistente.setClienteId(cli.getClienteId());
                clienteExistente.setGenero(cli.getGenero());
                clienteExistente.setTelefono(cli.getTelefono());
            Client clientUpdate = clientRepository.save(clienteExistente);
            return ClientEntityMapper.toDTO(clientUpdate);
         } catch (Exception e) {
        // Maneja errores específicos
        throw new ClientCreationException("Error al actualizar cliente en la base de datos.");
        }

    }


}


