package com.devChallengue.WSClientes.servicio;

import com.devChallengue.WSClientes.dto.ClienteResponseDTO;
import com.devChallengue.WSClientes.mapper.ClienteEntityMapper;
import com.devChallengue.WSClientes.modelo.Cliente;
import com.devChallengue.WSClientes.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // POST: Crear cliente
    public ClienteResponseDTO crearCliente(ClienteResponseDTO clienteResponseDTO) {
        Cliente clienteEntity = ClienteEntityMapper.toEntity(clienteResponseDTO);
        Cliente clienteGuardado = clienteRepositorio.save(clienteEntity);
        return ClienteEntityMapper.toDTO(clienteGuardado);
    }

    // GET: Obtener cliente por id
    public ClienteResponseDTO obtenerClientePorId(Long id) {
        Cliente clienteEntity = clienteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return ClienteEntityMapper.toDTO(clienteEntity);
    }

    // GET: Listar todos los clientes
    public List<ClienteResponseDTO> obtenerTodosClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        return clientes.stream()
                .map(ClienteEntityMapper::toDTO)
                .collect(Collectors.toList());
    }

    // DELETE: Eliminar cliente por id
    public void eliminarCliente(Long id) {
        if (!clienteRepositorio.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepositorio.deleteById(id);
    }
}


