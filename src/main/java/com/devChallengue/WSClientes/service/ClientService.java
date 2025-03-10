package com.devChallengue.WSClientes.service;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.mapper.ClientEntityMapper;
import com.devChallengue.WSClientes.model.Client;
import com.devChallengue.WSClientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // POST: Crear cliente
    public ClientDTO crearCliente(ClientDTO clientDTO) {
        Client clientEntity = ClientEntityMapper.toEntity(clientDTO);
        Client clientGuardado = clientRepository.save(clientEntity);
        return ClientEntityMapper.toDTO(clientGuardado);
    }

    // GET: Obtener cliente por id
    public ClientDTO obtenerClientePorId(Long id) {
        Client clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return ClientEntityMapper.toDTO(clientEntity);
    }

    // GET: Listar todos los clientes
    public List<ClientDTO> obtenerTodosClientes() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientEntityMapper::toDTO)
                .collect(Collectors.toList());
    }

    // DELETE: Eliminar cliente por id
    public void eliminarCliente(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clientRepository.deleteById(id);
    }
}


