package com.devChallengue.WSClientes.service;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.model.Client;

import java.util.List;

public interface IClientService {

    public ClientDTO crearCliente(ClientDTO clientDTO);

    public ClientDTO obtenerClientePorId(Long id);

    public List<ClientDTO> obtenerTodosClientes();

    public boolean eliminarCliente(Long id);

    public ClientDTO actualizarCliente(Long id, ClientDTO cli);

}
