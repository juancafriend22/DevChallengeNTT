package com.devChallengue.WSClientes.controller;

import com.devChallengue.WSClientes.dto.ClientDTO;
import com.devChallengue.WSClientes.dto.ClientRequestDTO;
import com.devChallengue.WSClientes.exception.ClientCreationException;
import com.devChallengue.WSClientes.exception.ClientNotFoundException;
import com.devChallengue.WSClientes.mapper.ClientEntityMapper;
import com.devChallengue.WSClientes.mapper.ClientRequestMapper;
import com.devChallengue.WSClientes.model.Client;
import com.devChallengue.WSClientes.service.IClientService;
import com.devChallengue.WSClientes.service.impl.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private IClientService clientService;


    @PostMapping
    public ResponseEntity<ClientDTO> crearCliente(@RequestBody ClientRequestDTO clientRequestDTO) {

            ClientDTO clientDTO = ClientRequestMapper.toClienteDTO(clientRequestDTO);
            ClientDTO clienteCreado = clientService.crearCliente(clientDTO);
            return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> obtenerCliente(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.obtenerClientePorId(id);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/buscar/{clienteId}")
   public ResponseEntity<ClientDTO> obtenerClientePorClienteId(@PathVariable String clienteId) {
        ClientDTO client = clientService.buscarClienteId(clienteId);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> obtenerClientes() {
        List<ClientDTO> clientesDTO = clientService.obtenerTodosClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClientDTO> actualizarCliente(@PathVariable Long id,@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientDTO clientDTO = ClientRequestMapper.toClienteDTO(clientRequestDTO);
        ClientDTO clienteActualizar = clientService.actualizarCliente(id,clientDTO);
        return new ResponseEntity<>(clienteActualizar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        boolean eliminado = clientService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }


}
